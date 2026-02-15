package org.wrabz.com.project_with_security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.wrabz.com.project_with_security.service.ProductService;

@Controller
public class MainPageController {

    private final ProductService productService;

    public MainPageController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/main")
    public String mainPage(Authentication a, Model model) {
        model.addAttribute("username", a.getName());
        model.addAttribute("products", productService.findAll());
        return "main";
    }
}
