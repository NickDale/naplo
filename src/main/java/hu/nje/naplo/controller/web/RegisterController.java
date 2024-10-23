package hu.nje.naplo.controller.web;

import hu.nje.naplo.entity.User;
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

    @PostMapping("/register")
    public String register(@ModelAttribute("felhasznalo") User felhasznalo,
                           Model model) {
//        // Ellenőrzések (pl. meglévő felhasználónév ellenőrzése)
//        if (/* felhasználónév már létezik */) {
//            model.addAttribute("errorMessage", "A felhasználónév már létezik.");
//            return "register";
//        }

//        // Jelszó hashelése, adatbázis mentés (példa)
//        felhasznalo.setJelszo(passwordEncoder.encode(felhasznalo.getJelszo()));
//        felhasznaloRepository.save(felhasznalo);

        return "redirect:/login";
    }
}

