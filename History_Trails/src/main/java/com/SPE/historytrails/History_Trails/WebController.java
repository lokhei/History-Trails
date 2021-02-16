package com.SPE.historytrails.History_Trails;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    @RequestMapping("/")
    public String index(){ return "index"; }
    @GetMapping(value = "/MShed")
    public String MShed(){
        return "MShed";
    }
    @GetMapping(value = "/BristolArtGallery")
    public String BristolArtGallery(){ return "BristolArtGallery"; }
    @GetMapping(value = "/contact")
    public String contact(){ return "contact"; }
    @GetMapping(value = "/Gallery2")
    public String gallery2(){ return "Gallery2"; }
    @GetMapping(value = "/Gallery3")
    public String gallery3(){
        return "Gallery3";
    }
    @GetMapping(value = "/Gallery4")
    public String gallery4(){
        return "Gallery4";
    }
    @GetMapping(value = "/Gallery5")
    public String gallery5(){
        return "Gallery5";
    }
    @GetMapping(value = "/test")
    public String test() {return "test";}
}

