// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-broadcasting-intents-is-security-sensitive@v1.0 defects=0}
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class BroadcastActivity : AppCompatActivity() {
    
    fun compliant() {
        val intent = Intent("com.example.ACTION_SENSITIVE_DATA")
        intent.putExtra("username", "user123")
        intent.putExtra("authToken", "abc123xyz456")
        
        // Compliant: Broadcasting intent with specific permission restriction.
        sendBroadcast(intent, "com.example.CUSTOM_PERMISSION")
    }
}
// {/fact}
