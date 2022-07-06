package com.calculator.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CalculatorController {
    

    @GetMapping("/add/{a}/{b}")
    public double add(@PathVariable double a, @PathVariable double b) {
        return a+b;
    }

    @GetMapping("/subtract/{a}/{b}")
    public double subtract(@PathVariable double a, @PathVariable double b) {
        return a-b;
    }

    @GetMapping("/multiply/{a}/{b}")
    public double multiply(@PathVariable double a, @PathVariable double b) {
        return a*b;
    }
    
    @GetMapping("/divide/{a}/{b}")
    public double divide(@PathVariable double a, @PathVariable double b) {
        return a/b;
    }
}
