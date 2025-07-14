# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-check-before-filter@v1.0 defects=0}
class AdminController < ApplicationController
  # Compliant: Using :only creates a whitelist approach which is more secure
  skip_before_filter :authenticate_admin, :only => :public_info
  
  def compliant
    # This action is properly protected by default
    render json: { message: "Protected action" }
  end
  
  def public_info
    # This specific action doesn't need authentication
    render json: { info: "public information" }
  end
end
# {/fact}
