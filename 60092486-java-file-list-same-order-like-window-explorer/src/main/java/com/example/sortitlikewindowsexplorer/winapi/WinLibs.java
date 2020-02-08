package com.example.sortitlikewindowsexplorer.winapi;

import static java.util.Collections.emptyMap;

import com.sun.jna.Library;
import com.sun.jna.Native;
import java.util.Map;

public final class WinLibs {
    private static final Map<String, Object> OPTIONS = emptyMap();
    private final static Shlwapi SHLWAPI;
    private final static Kernel32 KERNEL32;

    static {
        OperatingSystemUtil.verifyThatWeAreRunningOnWindows();

        SHLWAPI = load("Shlwapi", Shlwapi.class);
        KERNEL32 = load("Kernel32", Kernel32.class);
    }

    private WinLibs() {
    }

    public static Shlwapi shlwapi() {
        return SHLWAPI;
    }

    public static Kernel32 kernel32() {
        return KERNEL32;
    }

    private static <T extends Library> T
    load(String name, Class<T> interfaceClass) {
        return Native.load(name, interfaceClass, OPTIONS);
    }
}
