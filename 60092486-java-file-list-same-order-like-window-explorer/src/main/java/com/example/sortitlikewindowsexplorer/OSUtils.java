package com.example.sortitlikewindowsexplorer;

import java.util.Locale;

final class OSUtils {

    private OSUtils() {
    }

    /**
     * @implNote used https://stackoverflow.com/a/17506150/4494577 for
     * determining the OS.
     */
    static void verifyThatWeAreRunningOnWindows() {
        String operatingSystem = System
            .getProperty("os.name", "unknown")
            .toLowerCase(Locale.ROOT);

        if (!operatingSystem.contains("win")) {
            throw new IllegalStateException("This test class is intended for" +
                " Windows only");
        }
    }
}
