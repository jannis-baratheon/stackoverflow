package com.example.sortitlikewindowsexplorer.winapi;

import com.sun.jna.WString;
import com.sun.jna.win32.StdCallLibrary;

public interface Shlwapi extends StdCallLibrary {

    /**
     * String comparing function that Windows Explorer uses for sorting files by
     * their names.
     *
     * <pre>
     * int StrCmpLogicalW(
     *     PCWSTR psz1,
     *     PCWSTR psz2
     * );
     * </pre>
     *
     * @see <a href="https://docs.microsoft.com/pl-pl/windows/win32/api/shlwapi/nf-shlwapi-strcmplogicalw">StrCmpLogicalW</a>
     */
    int StrCmpLogicalW(WString psz1, WString psz2);
}
