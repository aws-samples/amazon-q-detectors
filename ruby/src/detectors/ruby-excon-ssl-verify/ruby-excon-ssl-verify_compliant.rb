# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-excon-ssl-verify@v1.0 defects=0}
require 'excon'

def compliant
    # Compliant: SSL verification has not been disabled.
    response = Excon.get('https://example.com')
    puts response.body
end
# {/fact}
