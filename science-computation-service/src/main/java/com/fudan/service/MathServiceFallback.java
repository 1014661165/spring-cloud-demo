package com.fudan.service;

import org.springframework.stereotype.Component;

@Component
public class MathServiceFallback implements MathService{

    public String add(Integer a, Integer b) {
        return String.format("error add %d %d", a, b);
    }

    public String div(Integer a, Integer b) {
        return String.format("error div %d %d", a, b);
    }
}
