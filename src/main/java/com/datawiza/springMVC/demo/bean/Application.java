package com.datawiza.springMVC.demo.bean;

import lombok.*;

@Builder
@Data//setter getter
@ToString//lombok
@NoArgsConstructor
@AllArgsConstructor
public class Application {
    Long id;
    String name;
    String domain;
    Boolean status;
}
