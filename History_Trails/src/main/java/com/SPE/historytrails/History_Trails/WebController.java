package com.SPE.historytrails.History_Trails;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
    @GetMapping(value = "/hello")
    public String helloWorld(@RequestParam(defaultValue = "world", required = false) String name, Model model){
        model.addAttribute("name", name);
        //First parameter is an attribute name, second parameter is an object to add.
        return "index" ;
    }
}

