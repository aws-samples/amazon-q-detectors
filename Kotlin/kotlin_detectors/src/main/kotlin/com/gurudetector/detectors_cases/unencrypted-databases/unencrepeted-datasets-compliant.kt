/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=kotlin-unencrypted-databases@v1.0 defects=0}
import com.gurudetector.helper.Realm
import com.gurudetector.helper.RealmConfiguration

// Compliant: Proper data encryption
fun unencrypted_datasets_compliant() {
    val config = RealmConfiguration.Builder()
            .encryptionKey(getKey())
            .build()
    val realm = Realm.getInstance(config)
}
fun getKey(): ByteArray {
    return ByteArray(64)
}
// {/fact}
