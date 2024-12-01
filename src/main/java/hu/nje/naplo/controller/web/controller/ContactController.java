package hu.nje.naplo.controller.web.controller;

import hu.nje.naplo.entity.ContactMessage;
import hu.nje.naplo.entity.User;
import hu.nje.naplo.repository.ContactMessageRepository;
import hu.nje.naplo.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping(path = "/contact")
@RequiredArgsConstructor
public class ContactController {

    private final ContactMessageRepository contactMessageRepository;
    private final UserRepository userRepository;

    @GetMapping
    public String showContactForm(Model model) {
        model.addAttribute("message", new ContactMessage());
        return "contact";
    }

    @PostMapping
    public String sendMessage(@ModelAttribute @Valid ContactMessage message, Model model, BindingResult result) {
        if (result.hasErrors()) {
            return "contact";
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            Optional<User> optionalUser = userRepository.findByUsername(username);
            optionalUser.ifPresent(user -> message.setUserId(user.getId()));
        }

        contactMessageRepository.save(message);

        model.addAttribute("message", "Az üzenet sikeresen elküldve!");
        return "contact";
    }

    //TODO: nem ide
//    @GetMapping("/messages")
//    public String viewMessages(Model model) {
//        List<ContactMessage> messages = contactMessageRepository.findAll(Sort.by(Sort.Direction.DESC, "sentAt"));
//        model.addAttribute("messages", messages);
//        return "messages";
//    }
}
