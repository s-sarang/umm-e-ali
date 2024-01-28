package com.ummeali.herbal.basket;

import com.ummeali.herbal.Navigate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class BasketController {

    private BasketService service;

    public BasketController(final BasketService service){
        this.service = service;
    }

    @PostMapping("/{customerId}/basket")
    public Integer create(Model model, Integer customerId){
        final Integer basketId = service.create(customerId);
        model.addAttribute("basketId", basketId);
        return basketId;
    }

    @GetMapping("/{customerId}/basket")
    public String get(Model model, @PathVariable Integer customerId){
        model.addAttribute("basket", service.get(customerId));
        return Navigate.toBasket();
    }

}
