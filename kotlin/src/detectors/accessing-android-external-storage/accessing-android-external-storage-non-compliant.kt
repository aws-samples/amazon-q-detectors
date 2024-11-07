// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-accessing-android-external-storage@v1.0 defects=1}
import android.content.Context
import java.io.File

// Noncompliant: `context.getExternalFilesDir` returns absolute path to the directory on the primary shared/external storage device.
fun accessing_android_external_storage_noncompliant(context : Context) {
   val file = File(context.getExternalFilesDir("external"), "sensitive_data.txt")
   file.writeText("This is sensitive information")
}
// {/fact}
