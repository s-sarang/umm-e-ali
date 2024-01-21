package com.ummeali.herbal.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @GetMapping("/signup")
    public String showSignUpForm() {
        return "user/sign-up";
    }

    @PostMapping("/create")
    public String create(Model model, User user) {
        final int userId = service.create(user);
        model.addAttribute("userId", userId);
        return "redirect:/store/home";
    }

    @GetMapping("/{userId}")
    public String showUserDetailsForm(Model model, @PathVariable Integer userId) {
        final User user = service.get(userId);
        model.addAttribute("user", user);
        return "edit-user-details";
    }

    /*@PostMapping("/{userId}/edit")
    public String update(Model model, @PathVariable Integer userId, User user){
        final User user = service.update(user);

    }*/

}
