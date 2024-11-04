# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-untrusted-deserialization@v1.0 defects=1}
require 'yaml'

class HomeController < ApplicationController

    def noncompliant 
        # Noncompliant: Untrusted user input is deserialized without validation.
        obj = YAML.load(params[:yaml_string])
    end
end
# {/fact}
