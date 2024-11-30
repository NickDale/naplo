package hu.nje.naplo.controller.web;

import hu.nje.naplo.entity.User;
import hu.nje.naplo.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("felhasznalo", new User());
        return "register";
    }

    private UserRepository userRepository;

    @PostMapping("/register")
    public String register(@ModelAttribute("felhasznalo") User felhasznalo,
                           Model model) {
        if (userRepository.findByUsername(felhasznalo.getUsername()).isPresent()) {
                model.addAttribute("errorMessage", "A felhasználónév már létezik.");
                return "register";
            }
//            User.setRole("USER");
            felhasznalo.setActive(true);
            userRepository.save(felhasznalo);
            return "redirect:/login";

    }
}

