package com.example.pirp2.controller;

import com.example.pirp2.entity.Piro;
import com.example.pirp2.repos.PiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class PiroController {



    @Autowired
    PiroRepository repos;




    @GetMapping("/addrecord")

    public String addData(){
        return "form";
    }

    @GetMapping("/")

    public String mainPage(Map<String,Object>model){



        List<Piro> allbill=repos.findAll();

        model.put("FIO",allbill);

        return "index";
    }


    @PostMapping("fillform")

    public String addData(@RequestParam String description,@RequestParam String tag,@RequestParam String naumen,@RequestParam String jiraID, @RequestParam String oldJiraID, Map<String,Object> model){

        Piro data= new Piro(description,tag,naumen,jiraID,oldJiraID);

        repos.save(data);

        model.put("FIO",data);

        return "redirect:/";


    }


    @PostMapping("srctag")

    public String getRecordByTag (@RequestParam String tag, Map<String,Object>model){

        List<Piro>listPiro=repos.findByTag(tag);

        model.put("FIO",listPiro);

        return "searchrecord";

    }

@GetMapping("/search")

    public String searchRec(){
        return "searchrecord";
}

@GetMapping("edit/{id}")
public  String editRecord(@PathVariable Integer id,Map <String,Object> model){

Piro piro=repos.getOne(id);
model.put("editFIO",piro);
return "index";

}

@PostMapping("editid")

public String getEditedInfo(@RequestParam Integer id,@RequestParam String description){

Piro piro=repos.getOne(id);

piro.setDescription(description);
repos.save(piro);

return "redirect:/";

    }

}
