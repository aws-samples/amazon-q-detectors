# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-untrusted-eval@v1.0 defects=0}
class HomeController < ApplicationController

    def assign_role(allowed_roles)
        # Assign received roles
    end

    def compliant 
        allowed_roles = "['admin', 'user']" 

        # Compliant: No external untrusted input used with `class_eval` making this operation safe.
        allowed_roles = Array.class_eval(allowed_roles)

        assign_role(allowed_roles)
    end
end
# {/fact}
