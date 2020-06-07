package com.datawiza.azure.demo.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/page")
public class PageController {

    @GetMapping("default")
    public Pageable page(@PageableDefault(page = 3,size = 333) Pageable page) {
        return page;
    }


    @GetMapping("aop")
    public Pageable getPage(@RequestParam(value = "page",required = false)Integer page,@RequestParam(value = "page",required = false)Integer page, Pageable page) {
        return page;
    }


}
