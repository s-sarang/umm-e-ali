package com.ummeali.herbal.basket;

import com.ummeali.herbal.Navigate;
import com.ummeali.herbal.products.ProductService;
import com.ummeali.herbal.session.SessionManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class BasketController {

    private static final Integer GUEST_CUSTOMER = 0;

    private SessionManager sessionManager;
    private BasketService service;

    public BasketController(final SessionManager sessionManager, final BasketService service){
        this.sessionManager = sessionManager;
        this.service = service;
    }

    @PostMapping("/{customerId}/basket")
    public Integer create(Model model, Integer customerId){
        final Integer basketId = service.create(customerId);
        sessionManager.verify(model, customerId);
        return basketId;
    }

    @GetMapping("/{customerId}/basket")
    public String get(Model model, @PathVariable Integer customerId){
        Basket basket = service.get(customerId);
        sessionManager.verify(model, customerId);
        model.addAttribute("checkoutItems", service.getCheckoutItems(basket));
        return Navigate.toBasket();
    }

    @PostMapping("/{customerId}/basket/{basketId}")
    public String update(Model model, @PathVariable Integer customerId, @PathVariable Integer basketId, ProductQuantity productQuantity){
        Basket basket = service.update(basketId, customerId, productQuantity.getProductId(), productQuantity.getQuantity());
        sessionManager.verify(model, customerId);
        model.addAttribute("checkoutItems", service.getCheckoutItems(basket));
        return Navigate.toProducts();
    }
}
