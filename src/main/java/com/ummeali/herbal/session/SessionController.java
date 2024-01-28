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

    @PostMapping("/login")
    public String login(Model model, Principal principal, Credentials credentials){
        if(credentials.getUsername() == null || credentials.getPassword() == null){
            return Navigate.toLogin();
        }
        service.login(credentials.getUsername(), credentials.getPassword());
        return Navigate.toHomepage();
    }

    @GetMapping("/logout")
    public String logout(Model model, Principal principal, Integer userId){
        service.logout(userId);
        return REDIRECT + Navigate.toHomepage();
    }


}
