/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=kotlin-receiving-intents-is-security-sensitive@v1.0 defects=0}
import android.content.BroadcastReceiver
import android.content.Context
import android.content.IntentFilter
import android.os.Handler

// Compliant: Intent receiver method is registered with limiting the broadcast permission.
fun receiving_intents_is_security_sensitive_compliant(
    context: Context, receiver: BroadcastReceiver?,
    filter: IntentFilter?,
    broadcastPermission: String?,
    scheduler: Handler?,
    flags: Int
) {
    context.registerReceiver(receiver, filter, broadcastPermission, scheduler)
}
// {/fact}
