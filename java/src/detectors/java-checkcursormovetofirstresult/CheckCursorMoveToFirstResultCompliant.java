// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-checkcursormovetofirstresult@v1.0 defects=0}
import android.database.Cursor;
import android.net.Uri;
import android.content.Context;
import stubs.Columns;

public class CheckCursorMoveToFirstResultCompliant {

    // Compliant: Checks if `cursor.moveToFirst()` returns true before accessing data, handling empty cursor case.
    public static String compliant(Context context, Uri uri) {
        String[] columns = { Columns.VALUE };
        try (Cursor cursor = context.getContentResolver().query(uri, columns, null, null, null)) {
            if (!cursor.moveToFirst()) {
                return null;
            }
            return cursor.getString(0);
        }
    }
}
// {/fact}
