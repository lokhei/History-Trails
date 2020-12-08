package com.SPE.historytrails.History_Trails;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {


//    @GetMapping(value = "/hello")
    @RequestMapping("/")
    public String index(){
//        model.addAttribute("name", name);
        //First parameter is an attribute name, second parameter is an object to add.
        return "index";
    }
    @GetMapping(value = "/MShed.html")
    public String QRCode(){
        return "MShed";
    }

    @GetMapping(value = "/BristolArtGallery.html")
    public String search(){
        return "BristolArtGallery"; }

//    @GetMapping(value = "/Gallery3.html")
//    public String gallery3(){
//        return "Gallery3";
//    }
}

