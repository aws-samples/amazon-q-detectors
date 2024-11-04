/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=kotlin-webview-debug-feature@v1.0 defects=1}
import android.webkit.WebView

// Noncompliant: The Debug feature should not be enabled or overridden.
fun webview_debug_feature_noncompliant() {
    WebView.setWebContentsDebuggingEnabled(true)
}
// {/fact}
