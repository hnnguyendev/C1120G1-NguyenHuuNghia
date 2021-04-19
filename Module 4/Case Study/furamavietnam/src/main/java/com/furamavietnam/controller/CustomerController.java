package com.furamavietnam.controller;

import com.furamavietnam.entity.Customer;
import com.furamavietnam.service.ICustomerService;
import com.furamavietnam.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    ICustomerService customerService;
    @Autowired
    ICustomerTypeService customerTypeService;

    @GetMapping("")
    public String getList(ModelMap modelMap, @PageableDefault(value = 5) Pageable pageable) {
        modelMap.addAttribute("customerList", customerService.findALl(pageable));

        return "admin/customer/list";
    }

    @GetMapping("/create")
    public String getCreateForm(ModelMap modelMap) {
        modelMap.addAttribute("customer", new Customer());
        modelMap.addAttribute("customerTypeList", customerTypeService.findAll());

        return "admin/customer/edit";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable Long id, ModelMap modelMap) {
        modelMap.addAttribute("customer", customerService.findById(id));
        modelMap.addAttribute("customerTypeList", customerTypeService.findAll());

        return "admin/customer/edit";
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Customer save(@RequestBody Customer customer) {

        return customerService.save(customer);
    }

    @GetMapping("/delete/{id}")
    public String getDeleteForm(@PathVariable Long id, ModelMap modelMap) {
        modelMap.addAttribute("customer", customerService.findById(id));

        return "admin/customer/delete";
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public Customer delete(@PathVariable Long id) {

        return customerService.delete(id);
    }
}
