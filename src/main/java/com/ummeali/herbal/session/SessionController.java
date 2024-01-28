package com.ummeali.herbal.session;

import com.ummeali.herbal.Navigate;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

import static com.ummeali.herbal.Navigate.REDIRECT;

@Controller
@RequestMapping("/user/auth")
public class SessionController {

    private SessionService service;

    public SessionController(SessionService service){
        this.service = service;
    }

    @GetMapping("/login")
    public String loginPage(){
        return Navigate.toLogin();
    }

    @PostMapping("/login")
    public String login(Model model, Credentials credentials){
        if(credentials.getUsername() == null || credentials.getPassword() == null){
            return Navigate.toLogin();
        }
        Session session = service.login(credentials.getUsername(), credentials.getPassword());
        model.addAttribute("customerSession", session);
        model.addAttribute("customerId", session.getCustomerId());
        return Navigate.toHomepage();
    }

    @GetMapping("/logout")
    public String logout(Model model, Integer customerId){
        Session session = service.logout(customerId);
        model.addAttribute("customerSession", session);
        model.addAttribute("customerId", 0);
        return Navigate.toHomepage();
    }
}
