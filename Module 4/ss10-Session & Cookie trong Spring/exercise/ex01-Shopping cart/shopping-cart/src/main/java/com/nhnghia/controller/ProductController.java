package com.nhnghia.controller;

import com.nhnghia.entity.Cart;
import com.nhnghia.entity.Product;
import com.nhnghia.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("cart")
public class ProductController {

    @Autowired
    IProductService productService;

    @ModelAttribute("cart")
    public Cart setUpUserForm() {
        Cart cart = new Cart();

        return cart;
    }

    @GetMapping("")
    public String getAllProduct(ModelMap modelMap) {
        modelMap.addAttribute("productList", productService.findAll());

        return "index";
    }

    @GetMapping("/view/{id}")
    public String getProduct(@PathVariable Long id, ModelMap modelMap) {
        modelMap.addAttribute("product", productService.findById(id));

        return "product";
    }

    @PostMapping("/addtocart")
    public String addToCart(@RequestParam Long id, @RequestParam Integer amount, ModelMap modelMap, @ModelAttribute("cart") Cart cart) {
        Product product = productService.findById(id);
        cart.addToCart(product, amount);
        modelMap.addAttribute("productList", productService.findAll());

        return "redirect:/";
    }

    @GetMapping("/cart")
    public String goToCart(ModelMap modelMap, @ModelAttribute("cart") Cart cart) {
        modelMap.addAttribute("itemList", cart.getCart());

        return "cart";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, @ModelAttribute("cart") Cart cart) {
        cart.remove(productService.findById(id));

        return "redirect:/cart";
    }

}
