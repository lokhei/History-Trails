package com.SPE.historytrails.History_Trails;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {


    @RequestMapping("/")
    public String index(){
//        model.addAttribute("name", name);
        //First parameter is an attribute name, second parameter is an object to add.
        return "index";
    }
    @GetMapping(value = "/MShed")
    public String MShed(){
        return "MShed";
    }

    @GetMapping(value = "/BristolArtGallery")
    public String BristolArtGallery(){
        return "BristolArtGallery"; }

    @GetMapping(value = "/contact")
    public String contact(){
        return "contact"; }

//    @GetMapping(value = "/Gallery3.html")
//    public String gallery3(){
//        return "Gallery3";
//    }
}

