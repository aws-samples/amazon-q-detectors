# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-ssl-mode-no-verify@v1.0 defects=0}
require 'net/http'
require 'uri'
require 'openssl'

url = 'https://example.com'
uri = URI.parse(url)

http = Net::HTTP.new(uri.host, uri.port)

# Compliant: SSL has not been disabled.
http.use_ssl = true

# {/fact}
