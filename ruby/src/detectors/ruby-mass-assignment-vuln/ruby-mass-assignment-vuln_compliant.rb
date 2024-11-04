# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-mass-assignment-vuln@v1.0 defects=0}
class UsersController < ApplicationController
    def compliant 
        # Compliant: Uses strong parameters with permit, allowing only specific attributes to be assigned to `User`.
        @user = User.new(user_params)
        if @user.save
            render json: { message: 'User created successfully', user: @user }
        else
            render json: { message: 'Failed to create a user.'}
        end
    end

    def user_params
        params.require(:user).permit(:name)
    end
end
# {/fact}
