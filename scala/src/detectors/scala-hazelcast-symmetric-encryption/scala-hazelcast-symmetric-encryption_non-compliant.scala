// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-hazelcast-symmetric-encryption@v1.0 defects=1}
import com.hazelcast.config.SymmetricEncryptionConfig

class HazelcastSymmetricEncryptionNoncompliant {

  def hazelcastSymmetricEncryptionNoncompliant(): Unit = {
    val symmetricEncryptionConfig = new SymmetricEncryptionConfig
    symmetricEncryptionConfig.setAlgorithm("AES")

    // Noncompliant: Iteration count is set too low, making encryption weak.
    symmetricEncryptionConfig.setIterationCount(1000)
  }

}
// {/fact}
