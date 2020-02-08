package com.example.sortitlikewindowsexplorer;

import com.example.sortitlikewindowsexplorer.winapi.Kernel32;

public class CompareDigitsAsNumbersCompareStringExComparator
    extends CompareStringExComparator {

    public CompareDigitsAsNumbersCompareStringExComparator() {
        super(Kernel32.CompareStringExOptionSet.of(
            Kernel32.CompareStringExOption.SORT_DIGITSASNUMBERS));
    }
}
