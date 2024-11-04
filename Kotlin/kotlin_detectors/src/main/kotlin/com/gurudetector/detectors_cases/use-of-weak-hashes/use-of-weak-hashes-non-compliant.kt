/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=kotlin-use-of-weak-hashes@v1.0 defects=1}
import java.security.MessageDigest

// Noncompliant: Using weak hashing algorithm which is insecure.
fun weak_hash_noncompliant(password: String): ByteArray {
    val md5Digest: MessageDigest = MessageDigest.getInstance("MD5")
    md5Digest.update(password.toByteArray(Charsets.UTF_8))
    val hashValue: ByteArray = md5Digest.digest()
    return hashValue
}
// {/fact}
