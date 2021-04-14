package com.fudan.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "math-service", fallback = MathServiceFallback.class)
public interface MathService {

    @GetMapping(value = "/math/add")
    String add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

    @GetMapping(value = "/math/div")
    String div(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}
