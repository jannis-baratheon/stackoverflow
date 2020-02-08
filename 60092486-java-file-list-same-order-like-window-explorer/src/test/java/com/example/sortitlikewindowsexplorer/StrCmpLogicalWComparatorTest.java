package com.example.sortitlikewindowsexplorer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class StrCmpLogicalWComparatorTest {

    private static StrCmpLogicalWComparator createDefault() {
        return new StrCmpLogicalWComparator();
    }

    @Test
    void case1() {
        StrCmpLogicalWComparator sut = createDefault();
        String[] fileNames = new String[]{
            "1 test -12.jpg",
            "1 test --11.jpg",
            "1 test ---10.jpg"
        };

        Arrays.sort(fileNames, sut);

        assertThat(fileNames)
            .containsExactly(
                "1 test ---10.jpg",
                "1 test --11.jpg",
                "1 test -12.jpg");
    }

    @Test
    void case2() {
        StrCmpLogicalWComparator sut = createDefault();
        String[] fileNames = new String[]{
            "1 test ---10.jpg",
            "1 test --11.jpg",
            "1 test -12.jpg",
            "1.jpg",
            "10.jpg",
            "2.jpg"
        };

        Arrays.sort(fileNames, sut);

        assertThat(fileNames)
            .containsExactly(
                "1 test ---10.jpg",
                "1 test --11.jpg",
                "1 test -12.jpg",
                "1.jpg",
                "2.jpg",
                "10.jpg");
    }
}
