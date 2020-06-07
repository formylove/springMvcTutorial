package com.datawiza.springMVC.demo.controller;

import com.datawiza.springMVC.demo.bean.Application;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/rest/applications")
public class RestfullController {
    ///rest/applications/1
    //path variable
    @GetMapping("/{appId}")
    public Application getApplication(@PathVariable("appId")Long appId){
        Application bilibili = Application.builder().id(appId).name("bilibili").domain("bilibili.com").build();
        return bilibili;
    }

    @PostMapping("")
    public String getApplication(@RequestBody Application application){
        return "{\"id\":2}";
    }


    @PutMapping("/{appId}")
    public String updateApplication(@PathVariable("appId")Long appId,@RequestBody Application application){
        System.out.println("########################## " + application);
        return "{\"status\":\"OK\"}";
    }

    @DeleteMapping("/{appId}")
    public String deleteApplication(@PathVariable("appId")Long appId){
        System.out.println("########################## " + appId);
        return "{\"status\":\"OK\"}";
    }


    @PatchMapping("/{appId}/status")
    public String setStatusOfApplication(@PathVariable("appId")Long appId,Boolean status){
        System.out.println("########################## " + status);
        return "{\"status\":\"OK\"}";
    }

    @GetMapping("/{appId}")
    public List<Application> getApplications(@RequestParam(value = "pageNumber") Integer pageNumber,@RequestParam(value = "pageSize") Integer pageSize){
        List<Application> applications = IntStream.range(0, 5).mapToObj((i) -> Application.builder().id(i + 0L).domain("cctv" + i + ".tv").name("中央" + i + "台").build()).collect(Collectors.toList());
        return applications;
    }

    @PostMapping("/{appId}")
    public List<Application> getApplications(@RequestBody Search search){
        List<Application> applications = IntStream.range(0, 5).mapToObj((i) -> Application.builder().id(i + 0L).domain("cctv" + i + ".tv").name("中央" + i + "台").build()).collect(Collectors.toList());
        return applications;
    }

    static class Search{
        Long start;
        Long end;
        Long minAmout;
        String type;
    }
}
