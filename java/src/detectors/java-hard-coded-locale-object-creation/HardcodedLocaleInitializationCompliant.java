// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-hard-coded-locale-object-creation@v1.0 defects=0}
import java.util.Locale;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
public class HardcodedLocaleInitializationCompliant {

    // Compliant: Uses `Locale.getDefault()` instead of hardcoding a specific locale.
    Locale DEFAULT_LOCALE = Locale.getDefault();
}
// {/fact}
