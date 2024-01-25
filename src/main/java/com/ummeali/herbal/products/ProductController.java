package com.ummeali.herbal.products;

import com.ummeali.herbal.Navigate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    public ProductService service;

    public ProductController(ProductService service){
        this.service = service;
    }

    @GetMapping("/list")
    public String getProduct(Model model){
        model.addAttribute("products", service.getAllProducts());

        return Navigate.toProducts();
    }

}
