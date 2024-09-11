package bebra.rzhork_ua.controller;

import bebra.rzhork_ua.model.entity.User;
import bebra.rzhork_ua.service.UserService;
import bebra.rzhork_ua.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/my/profile")
    public String myProfile(Model model) {
        String username = SecurityUtils.getCurrentUsername();
        if (username != null) {
            User user = userService.findByUsername(username);
            model.addAttribute("user", user);
            return "user/profile";
        }
        return "redirect:/login";
    }

}
