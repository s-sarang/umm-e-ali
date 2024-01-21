package com.ummeali.herbal.session;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user/auth")
public class SessionController {

    private SessionService service;

    public SessionController(SessionService service){
        this.service = service;
    }

    @GetMapping("/login")
    public String login(Model model, Principal principal, String username, String password){
        service.login(username, password);
        return "index";
    }

    @GetMapping("/logout")
    public String logout(Model model, Principal principal, Integer userId){
        service.logout(userId);
        return "index";
    }


}
