package com.nhnghia.controller;

import com.nhnghia.model.Customer;
import com.nhnghia.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/")
    public String listAll(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customerList", customerList);

        return "index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());

        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        if (customerService.findById(customer.getId()) == null) {
            customer.setId((int) (Math.random() * 10000));
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("success", "Add new customer successfully");
        } else {
            customerService.update(customer.getId(), customer);
            redirectAttributes.addFlashAttribute("success", "Update customer successfully");
        }

        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));

        return "create";
    }

    @GetMapping("{id}/delete")
    public String showDeleteForm(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));

        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("success", "Remove customer successfully");

        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));

        return "view";
    }

}
