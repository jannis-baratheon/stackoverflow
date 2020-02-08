package com.example.sortitlikewindowsexplorer.winapi;

import static com.sun.jna.win32.W32APIOptions.UNICODE_OPTIONS;
import static java.util.Collections.unmodifiableMap;

import com.sun.jna.Library;
import com.sun.jna.Native;
import java.util.Map;

public final class WinLibs {
    private static final Map<String, Object> OPTIONS =
        unmodifiableMap(UNICODE_OPTIONS);
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
