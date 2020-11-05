package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

//TASK 2
//@Controller
//public class WebController {
//    @GetMapping(value = "/hello")
//    @ResponseBody
//    public String helloWorld(){
//        return "Hello World!";
//    }
//}

//TASK 3
//@Controller
//public class WebController {
//    @GetMapping(value = "/hello")
//    @ResponseBody
//    public String helloWorld(@RequestParam(defaultValue = "world", required = false) String name){
//        return "Hello " + name ;
//    }
//}


//TASK 4
@Controller
public class WebController {
    @GetMapping(value = "/hello")
    public String helloWorld(@RequestParam(defaultValue = "world", required = false) String name, Model model){
        model.addAttribute("name", name);
        //First parameter is an attribute name, second parameter is an object to add.
        return "hello" ;
    }
}