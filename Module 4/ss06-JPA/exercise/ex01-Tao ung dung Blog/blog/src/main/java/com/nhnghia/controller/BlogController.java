package com.nhnghia.controller;

import com.nhnghia.entity.Blog;
import com.nhnghia.service.IBlogService;
import com.nhnghia.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    IBlogService blogService;

    @GetMapping("")
    public String findAll(ModelMap modelMap) {
        modelMap.addAttribute("blogList", blogService.findAll());

        return "blog/list";
    }

    @GetMapping("/save")
    public String showCreateForm(ModelMap modelMap) {
        modelMap.addAttribute("blog", new Blog());

        return "blog/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        if (blog.getId() != null) {
            System.out.println(blog.getCreateDate());
            redirectAttributes.addFlashAttribute("message", "Update blog successfully!");
        } else {
            blog.setCreateDate(DateUtil.getCurrentDate());
            redirectAttributes.addFlashAttribute("message", "Add new blog successfully!");
        }
        blogService.save(blog);

        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, ModelMap modelMap) {
        modelMap.addAttribute("blog", blogService.findById(id));

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
