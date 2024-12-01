package hu.nje.naplo.controller.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
//
//    @PostMapping("/login")
//    public String login(@ModelAttribute("login") UserDto userDto,
//                        Model model) {
//        Optional<User> user = userRepository.findByUsername("username");
//        if (user.isPresent() && user.get().getPassword().equals("password")) {
////            if(Objects.equals(User.getRole(), "diák")){
////                return "redirect:/diak/grades";
////            }
////            else if(Objects.equals(User.getRole(), "tanár")){
////                return "redirect:/tanar/grades";
////            }
////            else
//            return "redirect:/admin/grades";
//
//        } else {
//            model.addAttribute("loginError", "Helytelen felhasználónév vagy jelszó.");
//            return "login";
//        }
//    }
}

