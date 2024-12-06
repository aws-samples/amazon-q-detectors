// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-checkcursormovetofirstresult@v1.0 defects=1}
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

class OutputIgnoredOnMoveToFirstOperationNoncompliant {

    // Noncompliant: Code does not check if the cursor is empty.
    public static String nonCompliant(Context context, Uri uri) {
        String[] columns = { "name", "address" };
        try (Cursor cursor = context.getContentResolver().query(uri, columns, null, null, null)) {
            cursor.moveToFirst();
            return cursor.getString(0);
        }
    }
}
// {/fact}
