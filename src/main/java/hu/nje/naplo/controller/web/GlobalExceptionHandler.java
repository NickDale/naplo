package hu.nje.naplo.controller.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Bármely kivételt kezel, és a hiba esetén a home oldalra irányít
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        model.addAttribute("error", e.getMessage()); // Átadja a hiba üzenetet, ha szükséges
        return "home"; // A home oldalt mutatja hiba esetén
    }
}
