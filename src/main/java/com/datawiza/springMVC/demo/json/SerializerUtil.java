package com.datawiza.springMVC.demo.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.HashMap;
import java.util.Map;

public class SerializerUtil {
//jackson
    public static void main(String[] args) throws JsonProcessingException {
         final ObjectMapper JSON =
                new ObjectMapper()
                        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                        .configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true)
                        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                        .registerModule(new JavaTimeModule());

         Map<String,String> employee = new HashMap<>();
        employee.put("name","One punch man");
        employee.put("id","857");
        String s = JSON.writeValueAsString(employee);
        System.out.println("employee" +s);
    }
}
