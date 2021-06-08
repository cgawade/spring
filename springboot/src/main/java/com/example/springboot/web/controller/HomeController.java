package com.example.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@ResponseBody
@RequestMapping("/")
public class HomeController {

    @RequestMapping("home")
    public String home(){
        System.out.println("Inside home controller");
        return "Home Controller";
    }
}
