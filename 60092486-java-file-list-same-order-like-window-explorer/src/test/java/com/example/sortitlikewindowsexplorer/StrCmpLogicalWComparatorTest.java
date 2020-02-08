package com.example.sortitlikewindowsexplorer;

import java.util.Comparator;

class StrCmpLogicalWComparatorTest extends AbstractDigitsAsNumbersComparatorTest {

    @Override
    Comparator<String> createComparator() {
        return new StrCmpLogicalWComparator();
    }
}
