package com.furamavietnam.controller;

import com.furamavietnam.entity.Employee;
import com.furamavietnam.service.IDepartmentService;
import com.furamavietnam.service.IEducationService;
import com.furamavietnam.service.IEmployeeService;
import com.furamavietnam.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @Autowired
    IPositionService positionService;

    @Autowired
    IEducationService educationService;

    @Autowired
    IDepartmentService departmentService;

    @GetMapping("")
    public String getList(@RequestParam Optional<String> txtSearch,
                          ModelMap modelMap,
                          @PageableDefault(value = 5) Pageable pageable) {
        if (txtSearch.isPresent() && !txtSearch.get().equals("")) {
            modelMap.addAttribute("txtSearch", txtSearch.get());
            modelMap.addAttribute("employeeList", employeeService.findByContaining(txtSearch.get(), pageable));
        } else {
            modelMap.addAttribute("employeeList", employeeService.findAll(pageable));
        }

        return "admin/employee/list";
    }

    @GetMapping("/create")
    public String getCreateForm(ModelMap modelMap) {
        modelMap.addAttribute("employee", new Employee());
        modelMap.addAttribute("positionList", positionService.findAll());
        modelMap.addAttribute("educationList", educationService.findAll());
        modelMap.addAttribute("departmentList", departmentService.findAll());

        return "admin/employee/edit";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable Long id, ModelMap modelMap) {
        modelMap.addAttribute("employee", employeeService.findById(id));
        modelMap.addAttribute("positionList", positionService.findAll());
        modelMap.addAttribute("educationList", educationService.findAll());
        modelMap.addAttribute("departmentList", departmentService.findAll());

        return "admin/employee/edit";
    }

    @GetMapping("/delete/{id}")
    public String getDeleteForm(@PathVariable Long id, ModelMap modelMap) {
        modelMap.addAttribute("employee", employeeService.findById(id));

        return "admin/employee/delete";
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Employee save(@RequestBody Employee employee) {

        return employeeService.save(employee);
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public Employee delete(@PathVariable Long id) {

        return employeeService.deleteById(id);
    }
}
