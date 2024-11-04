# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-insufficient-rsa-key-size-fix@v1.0 defects=0}
require 'openssl'

def compliant
    # Compliant: Key size is sufficient.
    key_size = 2048
    key = OpenSSL::PKey::RSA.new(key_size)
end
# {/fact}
