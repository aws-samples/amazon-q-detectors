# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-faraday-ssl-verification-disabled@v1.0 defects=1}
require "faraday"

def noncompliant
    # Noncompliant: SSL certificate verification is disabled.
    connection = Faraday.new("http://example.com", ssl: { verify: false })
    response = connection.get("/")
end
# {/fact}
