package com.example.sortitlikewindowsexplorer;

import com.example.sortitlikewindowsexplorer.util.BitwiseUtil;
import com.example.sortitlikewindowsexplorer.winapi.Kernel32;
import com.example.sortitlikewindowsexplorer.winapi.WinLibs;
import com.sun.jna.Pointer;
import com.sun.jna.WString;
import java.util.Arrays;
import java.util.Comparator;

public class CompareStringExComparator implements Comparator<String> {

    private static Kernel32.LocaleInfo DEFAULT_LOCALE_INFO =
        Kernel32.LocaleInfo.INVARIANT;
    private static Kernel32.CompareStringExOptions DEFAULT_OPTIONS =
        Kernel32.CompareStringExOptions.NONE;

    private final int options;
    private final Kernel32.LocaleInfo localeInfo;

    public CompareStringExComparator() {
        this(DEFAULT_LOCALE_INFO, DEFAULT_OPTIONS);
    }

    public CompareStringExComparator(Kernel32.LocaleInfo localeInfo) {
        this(localeInfo, DEFAULT_OPTIONS);
    }

    public CompareStringExComparator(Kernel32.CompareStringExOptions... compareStringExOptions) {
        this(DEFAULT_LOCALE_INFO, compareStringExOptions);
    }

    public CompareStringExComparator(Kernel32.LocaleInfo localeInfo,
                                     Kernel32.CompareStringExOptions... compareStringExOptions) {

        this.options = BitwiseUtil.or(
            Arrays.stream(compareStringExOptions)
                .mapToInt(Kernel32.CompareStringExOptions::getOptionMask)
                .toArray());
        this.localeInfo = localeInfo;
    }

    @Override
    public int compare(String o1, String o2) {
        int compareStringExComparisonResult =
            WinLibs.kernel32()
                .CompareStringEx(
                    new WString(localeInfo.getName()),
                    options,
                    new WString(o1),
                    o1.length(),
                    new WString(o2),
                    o2.length(),
                    Pointer.NULL,
                    Pointer.NULL,
                    0);

        // CompareStringEx returns 1, 2, 3 respectively instead of -1, 0, 1
        return compareStringExComparisonResult - 2;
    }
}
