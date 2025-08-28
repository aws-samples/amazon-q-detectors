// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-unencrypted-files-in-app@v1.0 defects=1}
import java.io.File
import android.content.Context

class UserDataManager(private val context: Context) {
    
    fun saveUserCredentials(username: String, password: String) {
        // Noncompliant: Storing sensitive data in an unencrypted file
        val credentialsFile = File(context.filesDir, "user_credentials.txt")
        credentialsFile.writeText("$username:$password")
    }
}
// {/fact}
