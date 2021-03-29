package com.example.pirp2.controller;

import com.example.pirp2.entity.Piro;
import com.example.pirp2.repos.PiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
        model.put("warning","");


        return "index";
    }


    @PostMapping("fillform")

    public String addData(@RequestParam String description,@RequestParam String tag,@RequestParam String naumen,@RequestParam String jiraID, @RequestParam String oldJiraID, Map<String,Object> model,@RequestParam MultipartFile file){

        try {
            Piro data = new Piro(description, tag, naumen, jiraID, oldJiraID, file.getBytes(),file.getOriginalFilename(),file.getContentType());

            repos.save(data);

            model.put("FIO", data);
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";


    }

    @GetMapping("/downloadfile/{id}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer id){


        Piro piro = repos.findById(id).get();

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(piro.getDoctype()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+piro.getDocname()+"\"")
                .body(new ByteArrayResource(piro.getData()));
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
model.put("warning","");
return "index";

}

@GetMapping("delete/{id}")
public String deleteRecord(@PathVariable Integer id){

        repos.deleteById(id);

        return "redirect:/";

}

@PostMapping("editid")

public String getEditedInfo( Model model, @RequestParam(defaultValue = "0") Integer id, @RequestParam String description, @RequestParam String tag, @RequestParam String naumen, @RequestParam String jiraID, @RequestParam String oldjiraID ){

    if (id==0){
        List<Piro> allbill=repos.findAll();

        model.addAttribute("FIO",allbill);
        model.addAttribute("warning","выберите запись");
        return "index";}

Piro piro=repos.getOne(id);

piro.setDescription(description);
piro.setTag(tag);
piro.setNaumen(naumen);
piro.setJiraID(jiraID);
piro.setOldjiraID(oldjiraID);
repos.save(piro);

return "redirect:/";

    }




}
