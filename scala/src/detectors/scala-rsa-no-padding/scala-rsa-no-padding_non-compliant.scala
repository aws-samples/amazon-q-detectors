// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-rsa-no-padding@v1.0 defects=1}
import javax.crypto.Cipher

class RsaNoPaddingNoncompliant {

    @throws[Exception]
    def rsaNoPaddingNoncompliant(): Unit = {
        val cipher1 = null
        Cipher.getInstance(cipher1)
        val cipher2 = "RSA/NONE/NoPadding"
        // Noncompliant: Using `RSA` Algorithm without `OAEP`.
        Cipher.getInstance(cipher2)
    }

}

// {/fact}
