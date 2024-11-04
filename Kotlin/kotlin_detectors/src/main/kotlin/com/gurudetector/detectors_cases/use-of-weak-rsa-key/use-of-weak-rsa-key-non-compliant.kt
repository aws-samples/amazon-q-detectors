/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=kotlin-use-of-weak-rsa-key@v1.0 defects=1}
import java.security.KeyPairGenerator
// Noncompliant: The key 256 is not secure key length.
fun use_of_weak_rsa_noncompliant() {
    val keyGen: KeyPairGenerator = KeyPairGenerator.getInstance("RSA")
    keyGen.initialize(256)
}
// {/fact}
