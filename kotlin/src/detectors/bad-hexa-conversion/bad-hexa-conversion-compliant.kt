// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-bad-hexa-conversion@v1.0 defects=0}
import java.security.MessageDigest
import java.nio.charset.StandardCharsets
import kotlin.experimental.and

// Compliant: Using `String.format(\"%02X\",...)` which does not creates weak hash.
fun bad_hexa_conversion_compliant(password: String): String {
    val md: MessageDigest = MessageDigest.getInstance("SHA-1")
    val resultBytes: ByteArray = md.digest(password.toByteArray(StandardCharsets.UTF_8))

    var stringBuilder: StringBuilder = StringBuilder()
    for (b in resultBytes) {
        stringBuilder.append(String.format("%02X", b))
    }
    return stringBuilder.toString()
}
// {/fact}
