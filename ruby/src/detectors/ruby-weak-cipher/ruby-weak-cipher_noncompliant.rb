# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-weak-cipher@v1.0 defects=1}
require 'openssl'

class EncryptionService
  def noncompliant
    data = "sensitive information"
    key = "my_secret_key_123"
    # Noncompliant: Using weak DES cipher which is vulnerable to attacks.
    cipher = OpenSSL::Cipher.new('DES')
    cipher.encrypt
    cipher.key = key
    encrypted_data = cipher.update(data) + cipher.final
    encrypted_data
  end
end
# {/fact}
