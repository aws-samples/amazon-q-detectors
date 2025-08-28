# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-hardcoded-credentials-ide@v1.0 defects=0}
require 'net/http'

class APIClient
  def compliant
    # Compliant: Using environment variables to store sensitive credentials.
    api_key = ENV['API_KEY']
    password = ENV['API_PASSWORD']
    
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
