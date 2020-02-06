package com.example.sortitlikewindowsexplorer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Locale;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WindowsExplorerFileNameComparatorTest {

    /**
     * This test class makes sense only on windows.
     *
     * @implNote used https://stackoverflow.com/a/17506150/4494577 for determining the OS
     */
    @BeforeAll
    static void verifyThatWeAreOnWindows() {
        String operatingSystem = System
            .getProperty("os.name", "unknown")
            .toLowerCase(Locale.ROOT);

        if (!operatingSystem.contains("win")) {
            throw new IllegalStateException("This test class is intended for" +
                " Windows only");
        }
    }

    private WindowsExplorerFileNameComparator sut;

    @BeforeEach
    void setup() {
        sut = new WindowsExplorerFileNameComparator();
    }

    @Test
    void sorts_file_names_windows_explorer_way() {
        String[] fileNames = new String[] {
            "1 test -12.jpg",
            "1 test --11.jpg",
            "1 test ---10.jpg"
        };

        Arrays.sort(fileNames, sut);

        assertThat(fileNames)
            .containsExactly(
                "1 test ---10.jpg",
                "1 test --11.jpg",
                "1 test -12.jpg");
    }
}
