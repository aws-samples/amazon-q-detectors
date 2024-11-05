// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-bad-hexa-conversion@v1.0 defects=1}
import java.security.MessageDigest
import java.nio.charset.StandardCharsets
import kotlin.experimental.and

// Noncompliant: Using `Integer.toHexString()` which creates weak hash.
fun bad_hexa_conversion_noncompliant(password: String): String {
    val md: MessageDigest = MessageDigest.getInstance("SHA-1")
    val resultBytes: ByteArray = md.digest(password.toByteArray(StandardCharsets.UTF_8))

    var stringBuilder: StringBuilder = StringBuilder()
    for (b in resultBytes) {
        stringBuilder.append(Integer.toHexString(b.toInt() and 0xFF))
    }
    return stringBuilder.toString()
}
// {/fact}
