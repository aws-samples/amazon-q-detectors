# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-sensitive-http-action@v1.0 defects=0}
class HomeController < ApplicationController

  def do_get
    # handle get
  end

  def do_post
    # handle post
  end

  def do_patch
    # handle patch
  end

  def compliant 
      def login
          # Compliant: Separate branches for handling different http methods.
          if request.post?
            do_get
          elseif request.patch?
            do_patch
          elsif request.get
            do_post
          end
        end
  end

end
# {/fact}
