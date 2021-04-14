package com.fudan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MathController {

    /*@Value("${java.version}")
    String javaVersion;

    @Value("${spring.cloud.version}")
    String springCloudVersion;

    @Value("${spring.boot.version}")
    String springBootVersion;*/


    @GetMapping(value = "/add")
    public String add(@RequestParam Integer a,
                      @RequestParam Integer b){
        return String.format("%d", a+b);
    }

    @GetMapping(value = "/div")
    public String div(@RequestParam Integer a,
                      @RequestParam Integer b){
        return String.format("%d", a/b);
    }

    /*@GetMapping(value = "/version")
    public String version(){
        return String.format("java.version:%s\n" +
                "spring.boot.version:%s\n" +
                "spring.cloud.version:%s\n", javaVersion, springBootVersion, springCloudVersion);
    }*/
}
