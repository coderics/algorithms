package com.scatum.queen;

public enum Letter {

    a, b, c, d, e, f, g, h;

    public static String getName(int num) {
        for (Letter l : values()) {
            if (l.ordinal() == num) {
                return l.name();
            }
        }

        return null;
    }
}
