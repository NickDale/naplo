package hu.nje.naplo.controller.web.controller;

import hu.nje.naplo.entity.ContactMessage;
import hu.nje.naplo.repository.ContactMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/admins")
@RequiredArgsConstructor
public class AdminController {

    private final ContactMessageRepository contactMessageRepository;

    @GetMapping("/messages")
    public String viewMessages(Model model) {
        List<ContactMessage> messages = contactMessageRepository.findAll(Sort.by(Sort.Direction.DESC, "sentAt"));
        model.addAttribute("messages", messages);
        return "admin/messages";
    }

    @GetMapping(path = "/students")
    public String students(Model model) {
        return "admin/students";
    }

    @PostMapping(path = "/students")
    public String sudentCreation(Model model) {
        return "redirect:admin/students";
    }

    @GetMapping(path = "/grades")
    public String grades(Model model) {
        return "admin/grades";
    }

    @PostMapping(path = "/grades")
    public String gradesCreation(Model model) {
        return "redirect:admin/grades";
    }
}
