package com.ummeali.herbal.user;

import com.ummeali.herbal.Navigate;
import com.ummeali.herbal.session.SessionManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private SessionManager sessionManager;

    private UserService service;

    public UserController(SessionManager sessionManager, UserService service){
        this.sessionManager = sessionManager;
        this.service = service;
    }

    @GetMapping("/signup")
    public String signup() {
        return Navigate.toSignUpForm();
    }

    @GetMapping("/contacts")
    public String contacts() {
        return Navigate.toContactUs();
    }

    @PostMapping("/create")
    public String create(Model model, Customer customer) {
        service.create(customer);
        sessionManager.verify(model, null);
        return Navigate.toLogin();
    }

    @GetMapping("/{customerId}")
    public String showUserDetailsForm(Model model, @PathVariable Integer customerId) {
        final Customer customer = service.get(customerId);
        sessionManager.verify(model, customerId);
        model.addAttribute("customer", customer);
        return Navigate.toProfile();
    }

    @PostMapping("/{customerId}/edit")
    public String update(Model model, @PathVariable Integer customerId, Customer user){
        final Customer customer = service.update(user);
        sessionManager.verify(model, customerId);
        model.addAttribute("customer", customer);
        return Navigate.toProfile();
    }

}
