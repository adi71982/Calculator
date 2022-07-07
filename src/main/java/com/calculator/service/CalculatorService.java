package com.calculator.service;

import java.util.List;

import javax.script.ScriptException;

import com.calculator.entity.History;

public interface CalculatorService {
    
    double evaluateExpressionAndSave(String expression) throws ScriptException;

    List<History> getAllHistory();
}
