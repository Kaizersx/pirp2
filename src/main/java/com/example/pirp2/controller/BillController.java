package com.example.pirp2.controller;

import com.example.pirp2.entity.Billionaires;
import com.example.pirp2.repos.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class BillController {

    @Autowired
    BillRepository repos;

    @GetMapping("/getname")
    public String getBillName(Model model){

        Billionaires newbill= repos.getOne(1);

        model.addAttribute("name",newbill.getFirst_name());

        return "index";


    }


}
