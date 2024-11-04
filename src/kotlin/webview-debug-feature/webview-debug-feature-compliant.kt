/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=kotlin-webview-debug-feature@v1.0 defects=0}
import android.webkit.WebView
// Compliant: The Debug feature should not be enabled or overridden.
fun webview_debug_feature_compliant() {
   WebView.setWebContentsDebuggingEnabled(false)
}
// {/fact}
