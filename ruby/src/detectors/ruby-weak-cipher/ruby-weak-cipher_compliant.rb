# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-weak-cipher@v1.0 defects=0}
require 'openssl'

class EncryptionService
  def compliant
    data = "sensitive information"
    key = OpenSSL::Random.random_bytes(32)
    iv = OpenSSL::Random.random_bytes(16)
    # Compliant: Using strong AES-256-CBC cipher for secure encryption.
    cipher = OpenSSL::Cipher.new('AES-256-CBC')
    cipher.encrypt
    cipher.key = key
    cipher.iv = iv
    encrypted_data = cipher.update(data) + cipher.final
    encrypted_data
  end
end
# {/fact}
