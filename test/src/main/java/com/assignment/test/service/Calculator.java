package com.assignment.test.service;

import com.example.calculator.exception.DivisionByZeroException;
import com.example.calculator.exception.UnsupportedOperationException;
import com.example.calculator.operation.CalculatorOperation;
import com.example.calculator.operation.Operation;
import com.example.calculator.model.ChainedOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Calculator {

    private final List<CalculatorOperation> operations;

    @Autowired
    public Calculator(List<CalculatorOperation> operations) {
        this.operations = operations;
    }

    public Number calculate(Operation op, Number num1, Number num2) throws UnsupportedOperationException, DivisionByZeroException {
        return operations.stream()
                .filter(operation -> operation.supports(op))
                .findFirst()
                .map(operation -> {
                    try {
                        return operation.apply(num1, num2);
                    } catch (DivisionByZeroException e) {
                        throw e;
                    } catch (Exception e) {
                        throw new UnsupportedOperationException("An error occurred while performing the operation: " + e.getMessage());
                    }
                })
                .orElseThrow(() -> new UnsupportedOperationException("Operation not supported: " + op));
    }

    public Number chainCalculate(Number initialValue, List<ChainedOperation> chainedOperations)