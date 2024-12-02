// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-androidstartactivity@v1.0 defects=1}
import android.content.Context;
import android.content.Intent;

class MissingCheckOnAndroidStartActivityNoncompliant {

    // Noncompliant: There might be no application on the device to receive the implicit intent.
    public void startActivityNonCompliant(Context context, Intent shareIntent) {
        context.startActivity(shareIntent);
    }
}
// {/fact}
