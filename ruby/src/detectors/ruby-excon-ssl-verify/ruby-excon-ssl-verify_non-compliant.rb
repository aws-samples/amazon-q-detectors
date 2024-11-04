# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-excon-ssl-verify@v1.0 defects=1}
require 'excon'

def noncompliant
    # Noncompliant: SSL verification is disabled (not recommended for production).
    Excon.ssl_verify_peer = false

    response = Excon.get('https://example.com')
    puts response.body
end
# {/fact}
