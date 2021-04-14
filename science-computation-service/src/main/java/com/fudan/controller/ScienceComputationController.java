package com.fudan.controller;

import com.fudan.service.MathService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "fallback",commandProperties = {
        @HystrixProperty(name="metrics.rollingStats.timeInMilliseconds", value="5000"),
        @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="4"),
        @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="50"),
        @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="10000"),
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
public class ScienceComputationController {

    @Resource
    MathService mathService;

    @Resource
    DiscoveryClient discoveryClient;

    @GetMapping(value = "/add")
    @HystrixCommand
    public String add(@RequestParam Integer a, @RequestParam Integer b){
        log.info("science computation add");
        return mathService.add(a, b);
    }

    @GetMapping(value = "/div")
    @HystrixCommand
    public String div(@RequestParam Integer a, @RequestParam Integer b){
        log.info("science computation div");
        return mathService.div(a, b);
    }

    @GetMapping(value = "/exp")
    @HystrixCommand
    public String exp(@RequestParam Integer a, @RequestParam Integer b){
        int c = a / b;
        return "exp";
    }

    @GetMapping(value = "/discoverServices")
    @HystrixCommand
    public String discoverServices(){
        return discoveryClient.getServices().toString();
    }

    public String fallback(){
        return "default fallback";
    }
}
