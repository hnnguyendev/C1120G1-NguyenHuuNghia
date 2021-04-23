package com.furamavietnam.controller;

import com.furamavietnam.entity.ContractDetail;
import com.furamavietnam.service.IContractDetailService;
import com.furamavietnam.service.IExtraServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contractdetails")
public class ContractDetailController {

    @Autowired
    IContractDetailService contractDetailService;

    @Autowired
    IExtraServiceService extraServiceService;

    @GetMapping("/create")
    public String getCreateForm(ModelMap modelMap) {
        modelMap.addAttribute("contractDetail", new ContractDetail());
        modelMap.addAttribute("extraServiceList", extraServiceService.findAll());

        return "admin/contractdetail/edit";
    }

    @PostMapping("/save")
    @ResponseBody
    public ContractDetail save (@RequestBody ContractDetail contractDetail) {

        return contractDetailService.save(contractDetail);
    }
}
