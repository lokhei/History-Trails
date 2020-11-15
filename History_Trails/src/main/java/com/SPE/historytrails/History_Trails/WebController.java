package com.SPE.historytrails.History_Trails;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @GetMapping(value = "/QRCode.html")
    public String QRCode(){
        return "QRCode";
    }

    @GetMapping(value = "/SearchGallery.html")
    public String search(){
        return "SearchGallery";
    }
}

