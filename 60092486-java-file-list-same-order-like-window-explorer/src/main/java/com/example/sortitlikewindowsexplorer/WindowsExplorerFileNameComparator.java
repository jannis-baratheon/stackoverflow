package com.example.sortitlikewindowsexplorer;

import com.sun.jna.Native;
import java.util.Comparator;

public class WindowsExplorerFileNameComparator implements Comparator<String> {

    private static Shlwapi shlwapi = Native.load(
        "Shlwapi.dll", Shlwapi.class);

    public WindowsExplorerFileNameComparator() {
        OSUtils.verifyThatWeAreRunningOnWindows();
    }

    @Override
    public int compare(String o1, String o2) {
        return shlwapi.StrCmpLogicalW(o1, o2);
    }
}
