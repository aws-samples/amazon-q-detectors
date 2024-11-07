# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-ssl-verify-false@v1.0 defects=0}
require 'httparty'

# Compliant: SSL verification has not been disabled.
response = HTTParty.get("https://example.com/", verify: true)

# {/fact}
