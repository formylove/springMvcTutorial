package com.datawiza.azure.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Pageable;

@Controller
@RequestMapping("/azure")
public class AzureController {

    @RequestMapping("")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("greeting", "Aloha");
        return modelAndView;
    }


}
