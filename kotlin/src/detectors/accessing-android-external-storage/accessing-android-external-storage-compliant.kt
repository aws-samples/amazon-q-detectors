// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-accessing-android-external-storage@v1.0 defects=0}
import com.gurudetector.helper.ContextOther

// Compliant: `context.getExternalFilesDir` is not from Context object.
fun accessing_android_external_storage_compliant(context : ContextOther) {
   context.getExternalFilesDir("filepath")
}
// {/fact}
