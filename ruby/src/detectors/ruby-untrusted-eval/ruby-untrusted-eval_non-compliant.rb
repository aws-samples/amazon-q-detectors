# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-untrusted-eval@v1.0 defects=1}
class HomeController < ApplicationController

    def assign_role(allowed_roles)
        # Assign received roles
    end

    def noncompliant 
        allowed_roles = cookies['allowed_roles']

        # Noncompliant: Untrusted code might be executed.
        allowed_roles = Array.class_eval(allowed_roles)

        assign_role(allowed_roles)
    end
end
# {/fact}
