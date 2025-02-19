// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-checkcursormovetofirstresult@v1.0 defects=0}
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;
import com.kuxhausen.huemore.persistence.Definitions.MoodColumns;
import com.kuxhausen.huemore.state.Mood;
import java.util.Calendar;

public class CheckCursorMoveToFirstResultCompliant {

    public static @Nullable Mood compliant(String moodName, Context ctx) {
        String[] moodColumns = {MoodColumns.COL_MOOD_VALUE};
        String[] mWhereClause = {moodName};
        Cursor moodCursor =
                ctx.getContentResolver().query(Definitions.MoodColumns.MOODS_URI, moodColumns,
                        MoodColumns.COL_MOOD_NAME + "=?", mWhereClause, null);
        // Compliant: Checks applied before utilizing cursor.
        if (!moodCursor.moveToFirst()) {
            moodCursor.close();
            return null;
        }
        String encodedMood = moodCursor.getString(0);
        moodCursor.close();

        try {
            return HueUrlEncoder.decode(encodedMood).second.first;
        } catch (InvalidEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
// {/fact}
