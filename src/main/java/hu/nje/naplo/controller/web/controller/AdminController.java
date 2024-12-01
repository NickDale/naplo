package hu.nje.naplo.controller.web.controller;

import hu.nje.naplo.entity.ContactMessage;
import hu.nje.naplo.repository.ContactMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@PreAuthorize("hasRole('ADMIN')")
@Controller
@RequestMapping(path = "/admins")
@RequiredArgsConstructor
public class AdminController {

    private final ContactMessageRepository contactMessageRepository;

    @GetMapping("/dashboard")
    public String dashboard() {
        return "admin/dashboard";
    }

    @GetMapping("/messages")
    public String viewMessages(Model model) {
        List<ContactMessage> messages = contactMessageRepository.findAll(Sort.by(Sort.Direction.DESC, "sentAt"));
        model.addAttribute("messages", messages);
        return "admin/messages";
    }

    @GetMapping("/delete-message/{messageId}")
    public String viewMessages(@PathVariable int messageId, Model model) {
        contactMessageRepository.deleteById(messageId);
        return "redirect:/admins/messages";
    }

}
