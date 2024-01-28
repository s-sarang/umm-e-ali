package com.ummeali.herbal.home;

import com.ummeali.herbal.Navigate;
import com.ummeali.herbal.session.SessionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/store")
public class HomeController {

    private SessionService service;

    public HomeController(SessionService service){
        this.service = service;
    }

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("customerSession", service.guestSession());
        return Navigate.toHomepage();
    }
}
