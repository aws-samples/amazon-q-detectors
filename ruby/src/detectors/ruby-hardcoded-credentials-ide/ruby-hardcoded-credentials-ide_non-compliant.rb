# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-hardcoded-credentials-ide@v1.0 defects=1}
require 'net/http'

class APIClient
  def noncompliant
    # Noncompliant: Hardcoded credentials in source code pose security risks.
    api_key = "sk-1234567890abcdef"
    password = "mySecretPassword123"
    
    uri = URI('https://api.example.com/data')
    http = Net::HTTP.new(uri.host, uri.port)
    request = Net::HTTP::Get.new(uri)
    request['Authorization'] = "Bearer #{api_key}"
    request['X-Password'] = password
    
    response = http.request(request)
    response
  end
end
# {/fact}
