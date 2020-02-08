package com.example.sortitlikewindowsexplorer.winapi;

import java.util.Locale;

final class OperatingSystemUtil {

    private OperatingSystemUtil() {
    }

    static void verifyThatWeAreRunningOnWindows() {
        String operatingSystem = getOperatingSystemName();

        if (!operatingSystem.contains("win")) {
            throw new WorksOnlyOnWindowsException();
        }
    }

    /**
     * Used for determining the operating system. Based on
     * <a href="https://stackoverflow.com/a/17506150">this answer</a> to
     * <a href="https://stackoverflow.com/q/228477">this StackOverflow question</a>.
     * <p>
     * Kudos go to <a href="https://stackoverflow.com/users/1964633/nikesh-jauhari">Nikesh Jauhari</a>.
     *
     * @see <a href="https://stackoverflow.com/a/17506150">Nikesh Jauhari answer to "How do I programmatically determine operating system in Java?"</a>
     * @see <a href="https://stackoverflow.com/users/1964633/nikesh-jauhari">Nikesh Jauhari</a>
     */
    static String getOperatingSystemName() {
        return System
            .getProperty("os.name", "unknown")
            .toLowerCase(Locale.ROOT);
    }

    static class WorksOnlyOnWindowsException extends IllegalStateException {
        public WorksOnlyOnWindowsException() {
            super("This will not work on an OS other than Windows " +
                "as it uses the Windows native API. " +
                "Your operating system is: \"" +
                getOperatingSystemName() + "\"");
        }
    }
}
