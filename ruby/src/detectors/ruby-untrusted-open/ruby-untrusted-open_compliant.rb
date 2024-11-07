# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-untrusted-open@v1.0 defects=0}
class HomeController < ApplicationController

    def compliant 
        # Compliant: Rendering input for a file which cannot be controlled by the user.
        content = open("./tmp_files/dir/content.txt" , 'r').read
        render plain: content
    end

end
# {/fact}
