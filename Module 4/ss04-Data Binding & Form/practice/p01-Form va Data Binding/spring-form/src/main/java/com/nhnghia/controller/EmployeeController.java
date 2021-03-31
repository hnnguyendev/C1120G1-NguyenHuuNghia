package com.nhnghia.controller;

import com.nhnghia.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/show-form")
    public ModelAndView showForm() {
        return new ModelAndView("create", "employee", new Employee());
    }

    @PostMapping("/add-employee")
    public String add(@ModelAttribute Employee employee, Model model) {
        model.addAttribute("id", employee.getId());
        model.addAttribute("name", employee.getName());
        model.addAttribute("contactNumber", employee.getContactNumber());

        return "info";
    }
}
