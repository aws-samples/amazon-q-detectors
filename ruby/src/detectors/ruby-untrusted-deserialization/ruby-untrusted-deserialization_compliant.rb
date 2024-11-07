# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-untrusted-deserialization@v1.0 defects=0}
require 'yaml'

class HomeController < ApplicationController

    def compliant 
        # Compliant: Usage of `safe_load`.
        obj = YAML.safe_load(params[:yaml_string])
    end
end
# {/fact}
