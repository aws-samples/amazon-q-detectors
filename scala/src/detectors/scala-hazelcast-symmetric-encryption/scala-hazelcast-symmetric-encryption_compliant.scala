// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-hazelcast-symmetric-encryption@v1.0 defects=0}
import com.hazelcast.config.SymmetricEncryptionConfig

class HazelcastSymmetricEncryptionCompliant {

  def hazelcastSymmetricEncryptionCompliant(): Unit = {
    val symmetricEncryptionConfig = new SymmetricEncryptionConfig
    symmetricEncryptionConfig.setAlgorithm("AES")

    // Compliant: Uses a high iteration count for stronger encryption.
    symmetricEncryptionConfig.setIterationCount(1000000)
  }

}
// {/fact}
