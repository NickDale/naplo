package hu.nje.naplo.controller.web;

import hu.nje.naplo.entity.User;
import hu.nje.naplo.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;
import java.util.Optional;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {

        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            if(Objects.equals(User.getRole(), "diák")){
                return "redirect:/diak/grades";
            }
            else if(Objects.equals(User.getRole(), "tanár")){
                return "redirect:/tanar/grades";
            }
            else return "redirect:/admin/grades";

        } else {
            model.addAttribute("loginError", "Helytelen felhasználónév vagy jelszó.");
            return "login";
        }
    }
}

