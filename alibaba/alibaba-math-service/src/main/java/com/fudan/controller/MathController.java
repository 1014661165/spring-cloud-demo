package com.fudan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MathController {

    @Value("${java.version}")
    private String javaVersion;

    @GetMapping(value = "/alibaba/math/add")
    public String add(@RequestParam Integer a, @RequestParam Integer b){
        return String.format("%d", a + b);
    }

    @GetMapping(value = "/alibaba/math/div")
    public String div(@RequestParam Integer a, @RequestParam Integer b){
        return String.format("%d", a / b);
    }

    @GetMapping(value = "/alibaba/math/version")
    public String version(){
        return javaVersion;
    }
}
