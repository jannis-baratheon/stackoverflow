package com.example.sortitlikewindowsexplorer;

import com.example.sortitlikewindowsexplorer.winapi.Kernel32;
import com.example.sortitlikewindowsexplorer.winapi.WinLibs;
import java.util.Comparator;

public class CompareStringExComparator implements Comparator<String> {

    private static Kernel32.LocaleName DEFAULT_LOCALE_INFO =
        Kernel32.LocaleName.INVARIANT;
    private static Kernel32.CompareStringExOptions DEFAULT_OPTIONS =
        Kernel32.CompareStringExOptions.NONE;

    private final Kernel32.CompareStringExOptions options;
    private final Kernel32.LocaleName localeName;

    public CompareStringExComparator() {
        this(DEFAULT_LOCALE_INFO, DEFAULT_OPTIONS);
    }

    public CompareStringExComparator(Kernel32.CompareStringExOptions options) {
        this(DEFAULT_LOCALE_INFO, options);
    }

    public CompareStringExComparator(Kernel32.LocaleName localeName,
                                     Kernel32.CompareStringExOptions options) {
        this.localeName = localeName;
        this.options = options;
    }

    @Override
    public int compare(String o1, String o2) {
        int compareStringExComparisonResult =
            WinLibs.kernel32().CompareStringEx(localeName, options, o1, o2);

        // CompareStringEx returns 1, 2, 3 respectively instead of -1, 0, 1
        return compareStringExComparisonResult - 2;
    }
}
