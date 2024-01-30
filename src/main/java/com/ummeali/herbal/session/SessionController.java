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

    private SessionManager sessionManager;
    private SessionService service;

    public SessionController(SessionManager sessionManager, SessionService service){
        this.sessionManager = sessionManager;
        this.service = service;
    }

    @GetMapping("/login")
    public String loginPage(Model model){
        sessionManager.verify(model, null);
        return Navigate.toLogin();
    }

    @PostMapping("/login")
    public String login(Model model, Credentials credentials){
        if(credentials.getUsername() == null || credentials.getPassword() == null){
            return Navigate.toLogin();
        }
        Session session = service.login(credentials.getUsername(), credentials.getPassword());
        sessionManager.verify(model, session.getCustomerId());
        return Navigate.toHomepage();
    }

    @GetMapping("/logout")
    public String logout(Model model, Integer customerId){
        Session session = service.logout(customerId);
        sessionManager.verify(model, null);
        return Navigate.toHomepage();
    }
}
