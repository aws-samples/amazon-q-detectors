# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-insufficient-rsa-key-size-fix@v1.0 defects=1}
require 'openssl'

def noncompliant
    key_size = 512
    # Noncompliant: RSA key size is less than 2048 bits which makes it insecure. 
    key = OpenSSL::PKey::RSA.new(key_size)
end
# {/fact}
