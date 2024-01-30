package com.ummeali.herbal.products;

import com.ummeali.herbal.Navigate;
import com.ummeali.herbal.basket.Basket;
import com.ummeali.herbal.basket.BasketService;
import com.ummeali.herbal.session.SessionManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController {

    private static final Integer GUEST_CUSTOMER = 0;

    private final SessionManager sessionManager;

    public ProductService service;

    public ProductController(ProductService service, SessionManager sessionManager){
        this.service = service;
        this.sessionManager = sessionManager;
    }

    @GetMapping("/list")
    public String getProduct(Model model, @RequestParam(required = false) Integer customerId){
        model.addAttribute("products", service.getAllProducts());
        sessionManager.verify(model, customerId);
        return Navigate.toProducts();
    }

}
