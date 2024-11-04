# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-ssl-mode-no-verify@v1.0 defects=1}
require 'net/http'
require 'uri'
require 'openssl'

url = 'https://example.com'
uri = URI.parse(url)

http = Net::HTTP.new(uri.host, uri.port)

http.use_ssl = true

# Noncompliant: SSL verification is disabled.
http.verify_mode = OpenSSL::SSL::VERIFY_NONE

# {/fact}
