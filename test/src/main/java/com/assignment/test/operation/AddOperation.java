package com.assignment.test.operation;

import com.assignment.test.enums.Operation;
import org.springframework.stereotype.Component;

//Step 4: Implement basic operations using Java 8 features and Spring
@Component
public class AddOperation implements CalculatorOperation {
    @Override
    public boolean supports(Operation operation) {
        return operation == Operation.ADD;
    }

    @Override
    public Number apply(Number num1, Number num2) {
        return num1.doubleValue() + num2.doubleValue();
    }
}