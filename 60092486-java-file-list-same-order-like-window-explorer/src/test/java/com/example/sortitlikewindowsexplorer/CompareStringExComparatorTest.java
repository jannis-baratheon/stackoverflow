package com.example.sortitlikewindowsexplorer;

import com.example.sortitlikewindowsexplorer.winapi.Kernel32.CompareStringExOption;
import com.example.sortitlikewindowsexplorer.winapi.Kernel32.CompareStringExOptions;
import java.util.Comparator;
import org.junit.jupiter.api.Nested;

class CompareStringExComparatorTest {

    @Nested
    class DigitsAsNumbersTest extends AbstractDigitsAsNumbersComparatorTest {

        @Override
        Comparator<String> createComparator() {
            return new CompareStringExComparator(
                CompareStringExOptions.of(
                    CompareStringExOption.SORT_DIGITSASNUMBERS));
        }
    }

    @Nested
    class DigitsAsStringsTest extends AbstractDigitsAsStringsComparatorTest {

        @Override
        Comparator<String> createComparator() {
            return new CompareStringExComparator(
                CompareStringExOptions.of(
                    CompareStringExOption.SORT_STRINGSORT));
        }
    }
}
