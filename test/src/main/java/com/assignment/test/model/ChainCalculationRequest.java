package com.assignment.test.model;

import java.util.List;

public class ChainCalculationRequest {
    private Number initialValue;
    private List<ChainedOperation> chainedOperations;

    public Number getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(Number initialValue) {
        this.initialValue = initialValue;
    }

    public List<ChainedOperation> getChainedOperations() {
        return chainedOperations;
    }

    public void setChainedOperations(List<ChainedOperation> chainedOperations) {
        this.chainedOperations = chainedOperations;
    }
}