# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-request-without-validation@v1.0 defects=1}
require "rest-client"
require "open-uri"

# Noncompliant: SSL certificate validation is disabled.
resource = RestClient::Resource.new("https://example.com", verify_ssl: OpenSSL::SSL::VERIFY_NONE)
response = resource.get
# {/fact}
