package com.calculator.service;

import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.calculator.entity.History;
import com.calculator.respository.HistoryRepository;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    HistoryRepository historyRepository;

    

    public CalculatorServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }



    @Override
    @Transactional
    public double evaluateExpressionAndSave(String expression) throws ScriptException {
        // double c = ExpressionEvaluator.evaluateExpression(expression);
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("JavaScript");
        final double c = (Double)scriptEngine.eval(expression);
        historyRepository.save(new History(expression, c));
        return c;
    }



    @Override
    public List<History> getAllHistory() {
        return historyRepository.findAll();
    }

    
}
