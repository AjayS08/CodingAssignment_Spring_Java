package com.assignment.test.model;

import com.assignment.test.enums.Operation;

public class ChainedOperation {
    private Operation operation;
    private Number value;

    public ChainedOperation(Operation operation, Number value) {
        this.operation = operation;
        this.value = value;
    }

    public Operation getOperation() {
        return operation;
    }

    public Number getValue() {
        return value;
    }
}
