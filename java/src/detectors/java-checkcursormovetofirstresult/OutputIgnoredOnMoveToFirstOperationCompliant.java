// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-checkcursormovetofirstresult@v1.0 defects=0}
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

class OutputIgnoredOnMoveToFirstOperationCompliant {

    // Compliant: Code handles the case when the cursor is empty.
    public static String compliant(Context context, Uri uri) {
        String[] columns = { "name", "address" };
        try (Cursor cursor = context.getContentResolver().query(uri, columns, null, null, null)) {
            if (!cursor.moveToFirst()) {
                return null;
            }
            return cursor.getString(0);
        }
    }
}
// {/fact}
