package com.furamavietnam.controller;

import com.furamavietnam.entity.ResortService;
import com.furamavietnam.service.IRentTypeService;
import com.furamavietnam.service.IResortServiceService;
import com.furamavietnam.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/services")
public class ResortServiceController {

    @Autowired
    IResortServiceService resortServiceService;

    @Autowired
    IRentTypeService rentTypeService;

    @Autowired
    IServiceTypeService serviceTypeService;

    @GetMapping("")
    public String getList(@RequestParam Optional<String> txtSearch,
                          ModelMap modelMap,
                          @PageableDefault(value = 5) Pageable pageable) {
        if (txtSearch.isPresent() && !txtSearch.get().equals("")) {
            modelMap.addAttribute("txtSearch", txtSearch.get());
            modelMap.addAttribute("serviceList", resortServiceService.findByContaining(txtSearch.get(), pageable));
        } else {
            modelMap.addAttribute("serviceList", resortServiceService.findAll(pageable));
        }

        return "admin/service/list";
    }

    @GetMapping("/create")
    public String getCreateForm(ModelMap modelMap) {
        modelMap.addAttribute("service", new ResortService());
        modelMap.addAttribute("rentTypeList", rentTypeService.findAll());
        modelMap.addAttribute("serviceTypeList", serviceTypeService.findAll());

        return "admin/service/edit";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable Long id, ModelMap modelMap) {
        modelMap.addAttribute("service", resortServiceService.findById(id));
        modelMap.addAttribute("rentTypeList", rentTypeService.findAll());
        modelMap.addAttribute("serviceTypeList", serviceTypeService.findAll());

        return "admin/service/edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("service") @Valid ResortService resortService, BindingResult bindingResult, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("service", resortService);
            modelMap.addAttribute("rentTypeList", rentTypeService.findAll());
            modelMap.addAttribute("serviceTypeList", serviceTypeService.findAll());

            return "admin/service/edit";
        } else {
            resortServiceService.save(resortService);

            return "redirect:/services";
        }
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        resortServiceService.delete(id);

        return "redirect:/services";
    }
}
