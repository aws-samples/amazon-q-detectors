# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-server-side-request-forgery@v1.0 defects=1}
class UsersController < ApplicationController
    def noncompliant
        url = URI.parse(params[:url])

        # Noncompliant: Using user provided input to make a server side request without validation.
        resp = Net::HTTP.get(url)
        data = JSON.parse(resp)

        render json: data
    end
end
# {/fact}
