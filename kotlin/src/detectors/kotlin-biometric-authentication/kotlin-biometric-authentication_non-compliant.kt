// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-biometric-authentication@v1.0 defects=1}
import android.content.Context
import android.hardware.biometrics.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity

fun biometricAuthenticationNonCompliant(activity: FragmentActivity) {
    val executor = ContextCompat.getMainExecutor(activity)
    val callback = object : BiometricPrompt.AuthenticationCallback() {
        override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
            // Noncompliant: Accessing sensitive data without cryptographic verification
            accessSensitiveData()
        }
    }
    
    val biometricPrompt = BiometricPrompt(activity, executor, callback)
    val promptInfo = BiometricPrompt.PromptInfo.Builder()
        .setTitle("Authentication Required")
        .setSubtitle("Please authenticate to continue")
        .setNegativeButtonText("Cancel")
        .build()
    
    // Noncompliant: Using BiometricPrompt.authenticate() without a CryptoObject
    biometricPrompt.authenticate(promptInfo)
}

private fun accessSensitiveData() {
    // Access sensitive data without cryptographic protection
}
// {/fact}
