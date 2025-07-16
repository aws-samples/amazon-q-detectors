// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-broadcasting-intents-is-security-sensitive@v1.0 defects=1}
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class BroadcastActivity : AppCompatActivity() {
    
    fun noncompliant(context: Context) {
        val intent = Intent("com.example.ACTION_SENSITIVE_DATA")
        intent.putExtra("username", "user123")
        intent.putExtra("authToken", "abc123xyz456")
        
        // Noncompliant: Broadcasting intent without permission restriction allows any app to receive it.
        context.sendBroadcast(intent)
    }
}
// {/fact}
