package com.ummeali.herbal.session;

import com.ummeali.herbal.basket.Basket;
import com.ummeali.herbal.basket.BasketService;
import com.ummeali.herbal.products.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class SessionManager {

    private static final Integer GUEST_CUSTOMER = 0;
    public SessionService sessionService;
    public BasketService basketService;
    public ProductService productService;

    public SessionManager(SessionService sessionService, BasketService basketService, ProductService productService){
        this.sessionService = sessionService;
        this.basketService = basketService;
        this.productService = productService;
    }

    public void verify(Model model, Integer customerId){
        Basket customerBasket = null;
        if(customerId == null){ // If customer is not known, then customer is a 'Guest'.
            customerBasket = basketService.get(GUEST_CUSTOMER);
            model.addAttribute("customerId", GUEST_CUSTOMER);
            model.addAttribute("customerSession", sessionService.guestSession());
        } else { // If customer is known, then return customer id and basket id
            customerBasket = basketService.get(customerId);
            model.addAttribute("customerId", customerId);
            model.addAttribute("customerSession", sessionService.getSession(customerId));
        }
        model.addAttribute("basket", customerBasket);
        model.addAttribute("basketId", customerBasket == null ? GUEST_CUSTOMER : customerBasket.getBasketId());
        model.addAttribute("products", productService.getAllProducts());
    }
}
