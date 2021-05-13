package com.nhnghia.controller;

import com.nhnghia.entity.Ordering;
import com.nhnghia.service.ICustomerService;
import com.nhnghia.service.IOrderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("")
public class OrderingController {

    @Autowired
    IOrderingService orderingService;

    @Autowired
    ICustomerService customerService;

    @GetMapping("")
    public String getAll(@RequestParam Optional<String> txtSearch, ModelMap modelMap) {
        if (txtSearch.isPresent() && !txtSearch.get().equals("")) {
            modelMap.addAttribute("orderingList", orderingService.findByContaining(txtSearch.get()));
        } else {
            modelMap.addAttribute("orderingList", orderingService.findAll());
        }
        return "list";
    }

    @GetMapping("/save")
    public String showCreateForm(ModelMap modelMap) {
        modelMap.addAttribute("ordering", new Ordering());
        modelMap.addAttribute("customerList", customerService.findAll());

        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Valid Ordering ordering, BindingResult bindingResult, ModelMap modelMap, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("ordering", ordering);
            modelMap.addAttribute("customerList", customerService.findAll());
            return "create";
        } else {
            modelMap.addAttribute("ordering", ordering);
            modelMap.addAttribute("customerList", customerService.findAll());
            redirectAttributes.addFlashAttribute("message", "Add new blog successfully!");
            orderingService.save(ordering);
            return "redirect:/";
        }

    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, ModelMap modelMap) {
        modelMap.addAttribute("ordering", orderingService.findById(id));

        return "detail";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        orderingService.delete(id);

        return "redirect:/";
    }
}
