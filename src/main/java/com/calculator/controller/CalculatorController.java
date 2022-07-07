package com.calculator.controller;

import java.util.List;

import javax.script.ScriptException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calculator.entity.History;
import com.calculator.service.CalculatorService;

@RestController
@RequestMapping("/api")
public class CalculatorController {

    CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/add/{a}/{b}")
    public double add(@PathVariable double a, @PathVariable double b) throws ScriptException {
       return calculatorService.evaluateExpressionAndSave(String.format("%f+%f", a,b));
    }

    @GetMapping("/subtract/{a}/{b}")
    public double subtract(@PathVariable double a, @PathVariable double b) throws ScriptException {
        return calculatorService.evaluateExpressionAndSave(String.format("%f-%f", a,b));
    }

    @GetMapping("/multiply/{a}/{b}")
    public double multiply(@PathVariable double a, @PathVariable double b) throws ScriptException {
        return calculatorService.evaluateExpressionAndSave(String.format("%f*%f", a,b));
    }
    
    @GetMapping("/divide/{a}/{b}")
    public double divide(@PathVariable double a, @PathVariable double b) throws ScriptException {
        return calculatorService.evaluateExpressionAndSave(String.format("%f/%f", a,b));
    }

    @GetMapping("/calculate")
    public double evaluateExpression(@RequestParam("formula") String formula) throws ScriptException {
        return calculatorService.evaluateExpressionAndSave(formula);
    }

    @GetMapping("/history")
    public List<History> getHistory() {
        return calculatorService.getAllHistory();
    }

    @ExceptionHandler({ ScriptException.class })
    public String handleException() {
        return "Cannot Evaluate Expression (Hint: We cannot use '+' in url we have to encode it so instead of '+' use its encoded value '%2B')";
    }

}
