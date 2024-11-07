# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-faraday-ssl-verification-disabled@v1.0 defects=0}
require "faraday"

def compliant
    # Compliant: SSL verification is enabled.
    connection = Faraday.new("http://example.com", ssl: { verify: true })
    response = connection.get("/")
end
# {/fact}
