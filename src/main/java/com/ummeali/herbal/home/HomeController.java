package com.ummeali.herbal.home;

import com.ummeali.herbal.Navigate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/store")
public class HomeController {

    @GetMapping("/home")
    public String home(){
        return Navigate.toHomepage();
    }
}
