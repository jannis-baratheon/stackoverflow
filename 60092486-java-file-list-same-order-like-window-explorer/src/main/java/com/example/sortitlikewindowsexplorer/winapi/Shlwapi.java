package com.example.sortitlikewindowsexplorer.winapi;

import com.sun.jna.win32.StdCallLibrary;

public interface Shlwapi extends StdCallLibrary {

    /**
     * String comparing function that Windows Explorer uses for sorting files by
     * their names.
     *
     * int StrCmpLogicalW(
     *   PCWSTR psz1,
     *   PCWSTR psz2
     * );
     *
     * @see <a href="https://docs.microsoft.com/pl-pl/windows/win32/api/shlwapi/nf-shlwapi-strcmplogicalw">StrCmpLogicalW</a>
     */
    int StrCmpLogicalW(String psz1, String psz2);
}
