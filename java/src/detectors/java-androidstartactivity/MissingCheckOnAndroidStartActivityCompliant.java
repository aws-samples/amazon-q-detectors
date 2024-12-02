// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-androidstartactivity@v1.0 defects=0}
import android.content.Context;
import android.content.Intent;

class MissingCheckOnAndroidStartActivityCompliant {

    // Compliant: Called only if there is an application on the device to receive the implicit intent.
    public boolean startActivityCompliant(Context context, Intent shareIntent) {
        if (shareIntent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(shareIntent);
            return true;
        }
        return false;
    }
}
// {/fact}
