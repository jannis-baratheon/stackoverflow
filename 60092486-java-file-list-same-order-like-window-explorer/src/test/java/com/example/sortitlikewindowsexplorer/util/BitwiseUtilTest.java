package com.example.sortitlikewindowsexplorer.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BitwiseUtilTest {
    @Test
    void case1() {
        int actualResult = BitwiseUtil.or(0);

        assertThat(actualResult).isEqualTo(0);
    }

    @Test
    void case2() {
        int actualResult = BitwiseUtil.or(
            1, 2);

        assertThat(actualResult).isEqualTo(3);
    }

    @Test
    void case3() {
        int actualResult = BitwiseUtil.or(
            1, 1);

        assertThat(actualResult).isEqualTo(1);
    }

    @Test
    void case4() {
        int actualResult = BitwiseUtil.or(
            1, 2, 8);

        assertThat(actualResult).isEqualTo(11);
    }
}
