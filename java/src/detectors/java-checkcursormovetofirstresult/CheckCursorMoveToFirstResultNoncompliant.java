// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-checkcursormovetofirstresult@v1.0 defects=1}
import android.database.Cursor;
import android.net.Uri;
import android.content.Context;
import stubs.Columns;

public class CheckCursorMoveToFirstResultNoncompliant {

    // Noncompliant: Calls `cursor.moveToFirst()` without checking its return value, risking `IllegalStateException` if cursor is empty.
    public static String nonCompliant(Context context, Uri uri) {
        String[] columns = { Columns.VALUE };
        try (Cursor cursor = context.getContentResolver().query(uri, columns, null, null, null)) {
            cursor.moveToFirst();
            return cursor.getString(0);
        }
    }
}
// {/fact}
