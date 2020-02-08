package com.example.sortitlikewindowsexplorer;

import com.example.sortitlikewindowsexplorer.winapi.WinLibs;
import com.sun.jna.WString;
import java.util.Comparator;

public class StrCmpLogicalWComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return WinLibs.shlwapi().StrCmpLogicalW(new WString(o1), new WString(o2));
    }
}
