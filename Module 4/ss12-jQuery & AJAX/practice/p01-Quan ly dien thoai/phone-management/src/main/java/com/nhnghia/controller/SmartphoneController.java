package com.nhnghia.controller;

import com.nhnghia.entity.Smartphone;
import com.nhnghia.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SmartphoneController {

    @Autowired
    private ISmartphoneService smartphoneService;

//    @GetMapping("")
//    public String showIndex() {
//        return "index";
//    }

    @GetMapping("/create")
    public ModelAndView createSmartphonePage() {
        ModelAndView mav = new ModelAndView("new-phone");
        mav.addObject("sPhone", new Smartphone());
        return mav;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Smartphone createSmartphone(@RequestBody Smartphone smartphone) {
        return smartphoneService.save(smartphone);
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Smartphone> allPhones() {
        return smartphoneService.findAll();
    }

    @GetMapping("")
    public ModelAndView allPhonesPage() {
        ModelAndView modelAndView = new ModelAndView("all-phones");

        modelAndView.addObject("allphones", allPhones());
        return modelAndView;
    }

    @PostMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Smartphone deleteSmartphone(@PathVariable Long id) {
        return smartphoneService.delete(id);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editSmartphonePage(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("edit-phone");
        Smartphone smartphone = smartphoneService.findById(id);
        mav.addObject("sPhone", smartphone);
        return mav;
    }

    @PostMapping(value = "/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Smartphone editSmartphone(@PathVariable Long id, @RequestBody Smartphone smartphone) {
        smartphone.setId(id);
        return smartphoneService.save(smartphone);
    }

}
