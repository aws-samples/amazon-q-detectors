// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-unencrypted-databases@v1.0 defects=1}
import com.gurudetector.helper.Realm
import com.gurudetector.helper.RealmConfiguration

// Noncompliant: The lack of proper data encryption
fun unencrypted_datasets_noncompliant() {
    val config = RealmConfiguration.Builder().build()
    val realm = Realm.getInstance(config)
}
// {/fact}
