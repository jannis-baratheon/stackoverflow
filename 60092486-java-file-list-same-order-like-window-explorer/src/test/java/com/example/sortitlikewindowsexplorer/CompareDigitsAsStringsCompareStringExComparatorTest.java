package com.example.sortitlikewindowsexplorer;

import java.util.Comparator;

class CompareDigitsAsStringsCompareStringExComparatorTest extends AbstractDigitsAsStringsComparatorTest {

    @Override
    Comparator<String> createComparator() {
        return new CompareDigitsAsStringsCompareStringExComparator();
    }
}
