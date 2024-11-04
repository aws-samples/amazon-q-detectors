# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-server-side-request-forgery@v1.0 defects=0}
class UsersController < ApplicationController
    def compliant
        url = URI.parse("https://example.com")

        # Compliant: URL for getting the response data does not come from user controlled input.
        resp = Net::HTTP.get(url)
        data = JSON.parse(resp)

        render json: data
    end
end
# {/fact}
