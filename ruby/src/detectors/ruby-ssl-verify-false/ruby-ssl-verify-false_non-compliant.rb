# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-ssl-verify-false@v1.0 defects=1}
require 'httparty'

# Noncompliant: SSL verification is disabled.
response = HTTParty.get("http://example.com/", verify: false)

# {/fact}
