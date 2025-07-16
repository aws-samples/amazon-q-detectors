// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-use-of-weak-hashes@v1.0 defects=0}
import java.security.MessageDigest

// Compliant: Using secure hashing algorithm.
fun weak_hash_compliant(password: String): ByteArray {
    val shaDigest: MessageDigest = MessageDigest.getInstance("SHA-256")
    shaDigest.update(password.toByteArray(Charsets.UTF_8))
    val hashValue: ByteArray = shaDigest.digest()
    return hashValue
}
// {/fact}
