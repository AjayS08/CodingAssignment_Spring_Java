package com.assignment.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.ebay.demo.model.CalculateRequest;
import org.ebay.demo.model.ChainRequest;
import org.ebay.demo.model.Response;
import org.ebay.demo.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.calculator.model.CalculationRequest;
import com.example.calculator.model.ChainCalculationRequest;
import com.example.calculator.service.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/calculator")
public class CalculatorController {

    private final Calculator calculator;

    @Autowired
    public CalculatorController(Calculator calculator) {
        this.calculator = calculator;
    }

    @PostMapping("/calculate")
    public Number calculate(@RequestBody CalculationRequest request) {
        return calculator.calculate(request.getOperation(), request.getNum1(), request.getNum2());
    }

    @PostMapping("/chainCalculate")
    public Number chainCalculate(@RequestBody ChainCalculationRequest request) {
        return calculator.chainCalculate(request.getInitialValue(), request.getChainedOperations());
    }
}
