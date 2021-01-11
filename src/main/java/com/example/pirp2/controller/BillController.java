package com.example.pirp2.controller;

import com.example.pirp2.entity.Billionaires;
import com.example.pirp2.repos.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
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


    @GetMapping("/adddata")

    public String addData(){
        return "adddata";
    }


    @PostMapping("addData")

    public String addData(@RequestParam String firstname,@RequestParam String lastname,@RequestParam String career, Map<String,Object> model){

        Billionaires billionaires= new Billionaires(firstname,lastname,career);

        repos.save(billionaires);

        model.put("FIO",billionaires);

        return "index";


    }
}
