/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=kotlin-use-of-weak-rsa-key@v1.0 defects=0}
import java.security.KeyPairGenerator
// Compliant: The key 2048 is secure key length.
fun use_of_weak_rsa_compliant() {
    val keyGen = KeyPairGenerator.getInstance("RSA")
    keyGen.initialize(2048);
}
// {/fact}
