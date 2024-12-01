package hu.nje.naplo.controller.web.controller;

import hu.nje.naplo.controller.web.model.UserDto;
import hu.nje.naplo.entity.Role;
import hu.nje.naplo.entity.User;
import hu.nje.naplo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") UserDto userDto,
                           Model model) {
        if (userRepository.existsByUsernameIgnoreCase(userDto.getUsername())) {
            model.addAttribute("errorMessage", "A felhasználónév már létezik.");
            return "register";
        }
        final User user = new User();
        user.setName(userDto.getName());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());

        user.setRole(Role.valueOf("ROLE_"+userDto.getRole()));
        user.setActive(true);

        userRepository.save(user);
        return "redirect:/login";
    }
}

