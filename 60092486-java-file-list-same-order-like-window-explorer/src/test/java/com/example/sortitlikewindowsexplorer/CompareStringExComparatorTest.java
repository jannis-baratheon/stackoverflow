package com.example.sortitlikewindowsexplorer;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.sortitlikewindowsexplorer.winapi.Kernel32;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CompareStringExComparatorTest {

    @Test
    void case1() {
        CompareStringExComparator sut = new CompareStringExComparator(
            Kernel32.CompareStringExOptions.SORT_DIGITSASNUMBERS);

        String[] fileNames = new String[]{
            "10.jpg",
            "1 test -12.jpg",
            "1.jpg",
            "1 test --11.jpg",
            "1 test ---10.jpg",
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

    @Test
    void case2() {
        CompareStringExComparator sut = new CompareStringExComparator(
            Kernel32.CompareStringExOptions.SORT_STRINGSORT);

        String[] fileNames = new String[]{
            "10.jpg",
            "1 test -12.jpg",
            "1.jpg",
            "1 test --11.jpg",
            "1 test ---10.jpg",
            "2.jpg"
        };

        Arrays.sort(fileNames, sut);

        assertThat(fileNames)
            .containsExactly(
                "1 test ---10.jpg",
                "1 test --11.jpg",
                "1 test -12.jpg",
                "1.jpg",
                "10.jpg",
                "2.jpg");
    }

    @ParameterizedTest
    @CsvSource({
        "a,b,-1",
        "b,a,1",
        "a,a,0",
    })
    void compares_simple_strings(String string1,
                                 String string2,
                                 int expectedComparisonResult) {
        CompareStringExComparator sut = new CompareStringExComparator();

        assertThat(sut.compare(string1, string2))
            .isEqualTo(expectedComparisonResult);
    }
}
