package com.example.sortitlikewindowsexplorer.winapi;

import static com.example.sortitlikewindowsexplorer.winapi.JnaTypeUtil.wString;

import com.sun.jna.Pointer;
import com.sun.jna.WString;
import com.sun.jna.win32.StdCallLibrary;
import java.util.EnumSet;
import java.util.Locale;

/**
 * Based on <a href="https://stackoverflow.com/a/7205788">this answer</a>
 * to <a href="https://stackoverflow.com/q/7204663">this StackOverflow question</a>.
 * <p>
 * Kudos go to <a href="https://stackoverflow.com/users/98607/martin-liversage">Martin Liversage</a>.
 *
 * @see <a href="https://stackoverflow.com/users/98607/martin-liversage">Martin Liversage</a>
 * @see <a href="https://stackoverflow.com/a/7205788">Martin Liversage answer to "What is the shortest way in .NET to sort strings starting with 1, 10 and 2 and respect the number ordering?"</a>
 */
public interface Kernel32 extends StdCallLibrary {

    /**
     * Native WIN32 string comparing function.
     *
     * <pre>
     * int CompareStringEx(
     *     LPCWSTR                          lpLocaleName,
     *     DWORD                            dwCmpFlags,
     *     _In_NLS_string_(cchCount1)LPCWCH lpString1,
     *     int                              cchCount1,
     *     _In_NLS_string_(cchCount2)LPCWCH lpString2,
     *     int                              cchCount2,
     *     LPNLSVERSIONINFO                 lpVersionInformation,
     *     LPVOID                           lpReserved,
     *     LPARAM                           lParam
     * );
     * </pre>
     *
     * @see <a href="https://docs.microsoft.com/en-us/windows/win32/api/stringapiset/nf-stringapiset-comparestringex">CompareStringEx</a>
     */
    int CompareStringEx(WString lpLocaleName,
                        int dwCmpFlags,
                        WString lpString1,
                        int cchCount1,
                        WString lpString2,
                        int cchCount2,
                        Pointer lpVersionInformation,
                        Pointer lpReserved,
                        int lParam);

    default int CompareStringEx(LocaleName localeName,
                                CompareStringExOptions options,
                                String str1,
                                String str2) {
        return CompareStringEx(
            wString(localeName.getName()),
            options.getFlags(),
            wString(str1),
            str1.length(),
            wString(str2),
            str2.length(),
            Pointer.NULL,
            Pointer.NULL,
            0);
    }

    @SuppressWarnings("unused")
    enum CompareStringExOption {
        NONE(0x00000000),

        NORM_IGNORECASE(0x00000001),
        NORM_IGNORENONSPACE(0x00000002),
        NORM_IGNORESYMBOLS(0x00000004),
        LINGUISTIC_IGNORECASE(0x00000010),
        LINGUISTIC_IGNOREDIACRITIC(0x00000020),
        NORM_IGNOREKANATYPE(0x00010000),
        NORM_IGNOREWIDTH(0x00020000),
        NORM_LINGUISTIC_CASING(0x08000000),
        SORT_STRINGSORT(0x00001000),
        SORT_DIGITSASNUMBERS(0x00000008);

        private final int optionMask;

        CompareStringExOption(int optionMask) {
            this.optionMask = optionMask;
        }

        public int getOptionMask() {
            return optionMask;
        }
    }

    @SuppressWarnings("unused")
    class LocaleName {

        public static LocaleName USER_DEFAULT = new LocaleName((String) null);
        public static LocaleName INVARIANT = new LocaleName("");
        public static LocaleName SYSTEM_DEFAULT = new LocaleName("!sys-default-locale");

        private final String localeName;

        public LocaleName(Locale locale) {
            localeName = locale.toString();
        }

        private LocaleName(String locale) {
            this.localeName = locale;
        }

        public String getName() {
            return localeName;
        }
    }

    class CompareStringExOptions {
        public static CompareStringExOptions NONE =
            of(CompareStringExOption.NONE);
        private final int flags;

        private CompareStringExOptions(CompareStringExOption first,
                                       CompareStringExOption... rest) {
            this.flags = EnumSet.of(first, rest)
                .stream()
                .mapToInt(CompareStringExOption::getOptionMask)
                .reduce(0, (mask, option) -> mask | option);
        }

        public static CompareStringExOptions of(CompareStringExOption first,
                                                CompareStringExOption... rest) {
            return new CompareStringExOptions(first, rest);
        }

        int getFlags() {
            return flags;
        }
    }
}
