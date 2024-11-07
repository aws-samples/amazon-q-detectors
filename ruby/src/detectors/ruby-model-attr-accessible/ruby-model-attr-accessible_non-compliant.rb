# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-model-attr-accessible@v1.0 defects=1}
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
        # Noncompliant: Avoid using terms like `admin` , `account id` for mass assignment. 
        params.require(:user).permit(:account_id, :name, :telephone)
    end
end
# {/fact}
