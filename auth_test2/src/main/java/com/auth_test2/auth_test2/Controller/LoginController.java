package com.auth_test2.auth_test2.Controller;

import com.auth_test2.auth_test2.Entity.UserEntity;
import com.auth_test2.auth_test2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login2")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        UserEntity user = userService.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            if ("admin".equals(user.getRole())) {
                return "redirect:/admin/dashboard";
            } else {
                return "redirect:/user/dashboard";
            }
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}
