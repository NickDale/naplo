package hu.nje.naplo.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        // Példa ellenőrzés (helyettesítsd valódi felhasználóellenőrzéssel)
        if (username.equals("admin") && password.equals("admin123")) {
            // Sikeres bejelentkezés esetén átirányítás
            return "redirect:/home";
        } else {
            // Hibaüzenet megjelenítése a sablonban
            model.addAttribute("loginError", "Helytelen felhasználónév vagy jelszó.");
            return "login";
        }
    }
}

