package com.example.sortitlikewindowsexplorer;

import com.example.sortitlikewindowsexplorer.winapi.Kernel32;

public class CompareDigitsAsStringsCompareStringExComparator
    extends CompareStringExComparator {

    public CompareDigitsAsStringsCompareStringExComparator() {
        super(Kernel32.CompareStringExOptionSet.NONE);
    }
}
