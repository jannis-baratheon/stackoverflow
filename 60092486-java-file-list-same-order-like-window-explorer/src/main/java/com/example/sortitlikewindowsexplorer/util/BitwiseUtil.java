package com.example.sortitlikewindowsexplorer.util;

import java.util.Arrays;

public final class BitwiseUtil {
    private BitwiseUtil() {
    }

    public static int or(int... integers) {
        return Arrays
            .stream(integers)
            .reduce(0, (identity, argument) -> identity | argument);
    }
}
