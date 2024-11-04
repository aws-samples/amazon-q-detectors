/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=kotlin-webviews-security@v1.0 defects=0}
import android.webkit.WebView

// Compliant: Disabled JavaScript support for WebViews
fun webview_security_compliant(webView: WebView ) {
    webView.getSettings().setJavaScriptEnabled(false)
}
// {/fact}
