package com.taikang.demo.testEnum;

/**
 * @author Eunice
 * @date 2018/9/5
 */
public enum ExtendOperationEnum implements Operation {

    EXP("^") {
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },
    REMAINDER("%") {
        public double apply(double x, double y) {
            return x % y;
        }
    };


    private final String symble;

    ExtendOperationEnum(String symble) {
        this.symble = symble;
    }

    @Override
    public String toString() {
        return symble;
    }
}
