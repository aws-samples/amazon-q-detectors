# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-request-without-validation@v1.0 defects=0}
require "rest-client"
require "open-uri"

# Compliant: SSL validation is present.
resource = RestClient::Resource.new("https://example.com")
response = resource.get
# {/fact}
