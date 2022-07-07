package com.calculator.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class History {
    

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String expression;

    private double answer;

    public History(String expression, double answer) {
        this.expression = expression;
        this.answer = answer;
    }

    public History() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public double getAnswer() {
        return answer;
    }

    public void setAnswer(double answer) {
        this.answer = answer;
    }

    
}
