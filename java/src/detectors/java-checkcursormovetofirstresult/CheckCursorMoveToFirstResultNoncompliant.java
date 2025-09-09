// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-checkcursormovetofirstresult@v1.0 defects=1}
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.os.SystemClock;
import android.util.Log;
import com.kuxhausen.huemore.persistence.Definitions.MoodColumns;
import com.kuxhausen.huemore.state.Mood;
import java.util.Calendar;

public class CheckCursorMoveToFirstResultNonCompliant {

    public static Mood nonCompliant(String moodName, Context ctx) {
        String[] moodColumns = {MoodColumns.COL_MOOD_VALUE};
        String[] mWhereClause = {moodName};
        Cursor moodCursor =
                ctx.getContentResolver().query(Definitions.MoodColumns.MOODS_URI, moodColumns,
                        MoodColumns.COL_MOOD_NAME + "=?", mWhereClause, null);
        // Noncompliant: No check has been applied on the availability of the cursor before utilizing it.
        moodCursor.moveToFirst();
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
