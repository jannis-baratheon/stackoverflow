package com.example.sortitlikewindowsexplorer;

import java.util.Comparator;

class CompareDigitsAsNumbersCompareStringExComparatorTest extends AbstractDigitsAsNumbersComparatorTest {

    @Override
    Comparator<String> createComparator() {
        return new CompareDigitsAsNumbersCompareStringExComparator();
    }
}
