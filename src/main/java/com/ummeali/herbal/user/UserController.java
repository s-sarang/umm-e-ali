package com.ummeali.herbal.user;

import com.ummeali.herbal.Navigate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String signup() {
        return Navigate.toSignUpForm();
    }

    @PostMapping("/create")
    public String create(Model model, Customer customer) {
        final int customerId = service.create(customer);
        model.addAttribute("customerId", customerId);
        return Navigate.toLogin();
    }

    @GetMapping("/{customerId}")
    public String showUserDetailsForm(Model model, Integer customerId) {
        final Customer customer = service.get(customerId);
        model.addAttribute("user", customer);
        return "edit-user-details";
    }

    /*@PostMapping("/{userId}/edit")
    public String update(Model model, @PathVariable Integer userId, User user){
        final User user = service.update(user);

    }*/

}
