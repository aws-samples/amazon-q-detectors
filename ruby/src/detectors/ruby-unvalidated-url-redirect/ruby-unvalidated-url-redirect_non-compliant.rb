# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-unvalidated-url-redirect@v1.0 defects=1}
class UsersController < ActionController::Base
  def noncompliant
    # Noncompliant: Redirecting to user-provided URL without validation enables open redirect attacks.
    redirect_to params[:redirect_url]
  end
end
# {/fact}
