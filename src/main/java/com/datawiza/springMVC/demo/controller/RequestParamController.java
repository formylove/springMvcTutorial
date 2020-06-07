package com.datawiza.springMVC.demo.controller;

import com.datawiza.springMVC.demo.bean.Application;
import com.datawiza.springMVC.demo.enumerate.Car;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/req")
public class RequestParamController {
    @GetMapping("/boolean")
    public String getMarriedStatus(@RequestParam(value = "married", defaultValue = "no") Boolean married) {
        System.out.println("########################## " + married);
        return "{\"status\":\"" + married + "\"}";
    }


    @GetMapping("/map")
    public void getMarriedStatus(@RequestParam Map<String, String> info) {
        info.entrySet().stream().forEach((entry) -> System.out.println("key︰" + entry.getKey() + " value︰" + entry.getValue()));
    }

    //参数两种格式︰
    //{{host}}/req/list?roll=XiaoMing,Dennis
    //{{host}}/req/list?roll=XiaoMing,roll=Dennis
    @GetMapping("/list")
    public void getRoll(@RequestParam List<String> roll) {
        roll.stream().forEach((name) -> System.out.println("name︰" + name));
    }

    //大小写严格匹配

    //POJO -> json -> map
    @GetMapping("/enum")
    public Car getRoll(@RequestParam Car car) {
        return car;
    }

    @GetMapping("/list/enum")
    public List<Car> getCars(@RequestParam List<Car> cars) {
        return cars;
    }

    @GetMapping("/optional")
    public Car getCar(@RequestParam Optional<Car> car) {
        Car c = car.orElse(Car.JEEP);
        return c;
    }

    @GetMapping("/no/optional")
    public Car getCar(@RequestParam(required = false) Car car) {
        return car;
    }



    @GetMapping("/converter")
    public Application getCar(Application application) {
        return application;
    }

    @GetMapping("/pojo")
    public Application setCar(Application application) {
        return application;
    }


}
