package com.nhnghia.controller;

import com.nhnghia.entity.Category;
import com.nhnghia.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    ICategoryService categoryService;

    @GetMapping("")
    public String listAll(ModelMap modelMap, @PageableDefault(value = 2) Pageable pageable) {
        modelMap.addAttribute("categoryList", categoryService.findAll(pageable));

        return "category/list";
    }

    @GetMapping("/save")
    public String showCreateForm(ModelMap modelMap) {
        modelMap.addAttribute("category", new Category());

        return "category/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        if (category.getId() == null) {
            //...
        } else {
            //...
        }
        categoryService.save(category);

        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, ModelMap modelMap) {
        modelMap.addAttribute("category", categoryService.findById(id));

        return "category/create";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        categoryService.delete(id);

        return "redirect:/category";
    }
}
