package com.ummeali.herbal.user;

import com.ummeali.herbal.Navigate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.ummeali.herbal.Navigate.REDIRECT;

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

    @GetMapping("/{userId}")
    public String showUserDetailsForm(Model model, @PathVariable Integer userId) {
        final Customer customer = service.get(userId);
        model.addAttribute("user", customer);
        return "edit-user-details";
    }

    /*@PostMapping("/{userId}/edit")
    public String update(Model model, @PathVariable Integer userId, User user){
        final User user = service.update(user);

    }*/

}
