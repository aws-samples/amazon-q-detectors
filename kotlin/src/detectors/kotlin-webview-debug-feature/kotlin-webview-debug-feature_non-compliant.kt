// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-webview-debug-feature@v1.0 defects=1}
import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // Noncompliant: Enabling WebView debugging in production code exposes the application to security risks.
        WebView.setWebContentsDebuggingEnabled(true)
        
        val webView = findViewById<WebView>(R.id.webview)
        webView.loadUrl("https://example.com")
    }
}
// {/fact}
