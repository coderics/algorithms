package com.scatum.shortestpath;

enum Symbol {

    A("A"),
    B("B"),

    EMPTY("."),
    CLOSED("x");


    public final String value;

    private Symbol(String value) {
        this.value = value;
    }

    public static boolean isExist(String value) {
        for (Symbol s : Symbol.values()) {
            if (s.value.equals(value)) {
                return true;
            }
        }

        return false;
    }
}
