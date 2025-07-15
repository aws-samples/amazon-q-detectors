# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-mass-assignment-vuln@v1.0 defects=1}
class UsersController < ApplicationController
    def noncompliant 
        # Noncompliant: Directly assigning all user-provided parameters to the model without filtering.
        @user = User.new(params[:user])
        if @user.save
            render json: { message: 'User created successfully', user: @user }
        else
            render json: { message: 'Failed to create a user.'}
        end
    end
end
# {/fact}
