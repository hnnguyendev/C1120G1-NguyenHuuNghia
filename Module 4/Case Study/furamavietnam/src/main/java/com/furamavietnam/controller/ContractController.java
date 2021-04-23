package com.furamavietnam.controller;

import com.furamavietnam.entity.Contract;
import com.furamavietnam.service.IContractService;
import com.furamavietnam.service.ICustomerService;
import com.furamavietnam.service.IEmployeeService;
import com.furamavietnam.service.IResortServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    IContractService contractService;

    @Autowired
    IEmployeeService employeeService;

    @Autowired
    ICustomerService customerService;

    @Autowired
    IResortServiceService resortServiceService;

    @GetMapping("")
    public String getList(ModelMap modelMap) {
        modelMap.addAttribute("contractList", contractService.findALl());

        return "admin/contract/list";
    }

    @GetMapping("/create")
    public String getCreateForm(ModelMap modelMap) {
        modelMap.addAttribute("contract", new Contract());
        modelMap.addAttribute("employeeList", employeeService.findAll());
        modelMap.addAttribute("customerList", customerService.findAll());
        modelMap.addAttribute("serviceList", resortServiceService.findAll());

        return "admin/contract/edit";
    }

    @PostMapping("/save")
    @ResponseBody
    public Contract save(@RequestBody Contract contract) {

        return contractService.save(contract);
    }

}
