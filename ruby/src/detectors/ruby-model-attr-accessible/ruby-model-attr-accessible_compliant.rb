# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-model-attr-accessible@v1.0 defects=0}
class UsersController < ApplicationController
    def create
      @user = User.new(user_params)
      
      if @user.save
        redirect_to @user, notice: 'User created successfully.'
      else
        render :new
      end
    end
  
    private
  
    def user_params
        # Compliant: Mass assignment doesn't involve any sensitive attributes.
        params.require(:user).permit(:name, :telephone)
    end
end
# {/fact}
