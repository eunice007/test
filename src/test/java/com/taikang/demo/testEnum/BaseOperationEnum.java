package com.taikang.demo.testEnum;

/**
 * @author Eunice
 * @date 2018/9/5
 */
public enum BaseOperationEnum implements Operation {

    PLUS("+") {
        public double apply(double x, double y) {
            return x+y;
        }
    },
    DESC("-") {
        public double apply(double x, double y) {
            return x-y;
        }
    },
    MULTI("*") {
        public double apply(double x, double y) {
            return x*y;
        }
    },
    DIVIDE("/") {
        public double apply(double x, double y) {
            return x/y;
        }
    };

    private final String symbol;

    BaseOperationEnum(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
