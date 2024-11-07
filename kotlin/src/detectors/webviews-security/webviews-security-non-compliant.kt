// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-webviews-security@v1.0 defects=1}
import android.webkit.WebView

// Noncompliant: Enabled JavaScript support for WebViews
fun webview_security_noncompliant(webView: WebView ) {
    webView.getSettings().setJavaScriptEnabled(true)
}
// {/fact}
