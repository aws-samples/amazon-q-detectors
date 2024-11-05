// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-receiving-intents-is-security-sensitive@v1.0 defects=1}
import android.content.BroadcastReceiver
import android.content.Context
import android.content.IntentFilter
import android.os.Handler

// Noncompliant: Intent receiver method is registered without specifying any broadcast permission.
fun receiving_intents_is_security_sensitive_noncompliant(
    context: Context, receiver: BroadcastReceiver?,
    filter: IntentFilter?,
    scheduler: Handler?,
    flags: Int
) {
    context.registerReceiver(receiver, filter)
    context.registerReceiver(receiver, filter, flags)

}
// {/fact}
