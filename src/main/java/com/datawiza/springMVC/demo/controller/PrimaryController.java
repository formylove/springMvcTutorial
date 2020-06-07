package com.datawiza.springMVC.demo.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Locale;

@RestController
@RequestMapping("/primary")
public class PrimaryController {

    //可以 en-Us
    //不可以 en_us
    @PatchMapping("/method/locale")
    public void setCar(HttpMethod httpMethod, Locale locale) {
        System.out.println("########################## " + httpMethod.name());
        System.out.println("########################## " + locale.toString());
    }


    @PatchMapping(value = "/req/response",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value= HttpStatus.CREATED,reason = "an normal exception")
    public void setCar(HttpServletRequest request, HttpServletResponse response, Writer out) throws IOException {
        System.out.println("getRequestURL " + request.getRequestURL());
        System.out.println("getRequestURI " + request.getRequestURI());
        System.out.println("getPathInfo " + request.getPathInfo());
        System.out.println("getQueryString " + request.getQueryString());
        System.out.println("getMethod " + request.getMethod());
        System.out.println("getHeader " + request.getHeader("accept-language"));

        response.addHeader("status","bravo!");

        out.write("Done is better than perfect");
        System.out.println("########################## " +(out==request));
        response.getWriter().write("十亿少女的梦");
    }




}
