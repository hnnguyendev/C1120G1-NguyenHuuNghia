package com.nhnghia.controller;

import com.nhnghia.entity.Blog;
import com.nhnghia.service.IBlogService;
import com.nhnghia.service.ICategoryService;
import com.nhnghia.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    IBlogService blogService;

    @Autowired
    ICategoryService categoryService;

    @GetMapping("") //(name = "sort", required = false, defaultValue = "asc") - @PageableDefault(value = 2) Pageable pageable
    public String listAll(@RequestParam Optional<String> txtSearch,
                          @RequestParam Optional<Long> categoryIdKey,
                          @RequestParam Optional<String> sortKey,
                          @RequestParam Optional<String> sortByKey,
                          ModelMap modelMap,
                          @PageableDefault(value = 2) Pageable pageable) {
        if (txtSearch.isPresent() && !txtSearch.get().equals("")) {
            modelMap.addAttribute("txtSearch", txtSearch.get());
            modelMap.addAttribute("blogList", blogService.findByTitleContaining(txtSearch.get(), pageable));

        } else if (categoryIdKey.isPresent()) {
            System.out.println(categoryIdKey.get());
            modelMap.addAttribute("categoryId", categoryIdKey.get());
            modelMap.addAttribute("blogList", blogService.findByCategoryId(categoryIdKey.get(), pageable));
        } else if (sortKey.isPresent() && !sortKey.get().equals("")) {
            System.out.println(sortKey.get());
            if (sortKey.get().equals("asc")) {
                modelMap.addAttribute("sort", sortKey.get());
                modelMap.addAttribute("sortBy", sortByKey.get());
//                modelMap.addAttribute("blogList", blogService.findByOrderByCreateDateAsc(pageable));
                Pageable pageableSort = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(sortByKey.get()).ascending());
                modelMap.addAttribute("blogList", blogService.findAll(pageableSort));

            }
            if (sortKey.get().equals("desc")) {
                modelMap.addAttribute("sort", sortKey.get());
                modelMap.addAttribute("sortBy", sortByKey.get());
//                modelMap.addAttribute("blogList", blogService.findByOrderByCreateDateDesc(pageable));
//                modelMap.addAttribute("blogList", blogService.findAll(pageable, Sort.by(Sort.Direction.DESC, "createDate")));
                Pageable pageableSort = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(sortByKey.get()).descending());
                modelMap.addAttribute("blogList", blogService.findAll(pageableSort));
            }

        } else {
            modelMap.addAttribute("blogList", blogService.findAll(pageable));
        }
        modelMap.addAttribute("categories", categoryService.findAll());

        return "blog/list";
    }

    @GetMapping("/save")
    public String showCreateForm(ModelMap modelMap) {
        modelMap.addAttribute("blog", new Blog());
        modelMap.addAttribute("categories", categoryService.findAll());

        return "blog/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        if (blog.getId() != null) {
            redirectAttributes.addFlashAttribute("message", "Update blog successfully!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Add new blog successfully!");
        }
        blogService.save(blog);

        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, ModelMap modelMap) {
        modelMap.addAttribute("blog", blogService.findById(id));
        modelMap.addAttribute("categories", categoryService.findAll());

        return "blog/create";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, ModelMap modelMap) {
        modelMap.addAttribute("blog", blogService.findById(id));

        return "blog/detail";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        blogService.delete(id);

        return "redirect:/blog";
    }

}
