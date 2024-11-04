# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-untrusted-open@v1.0 defects=1}
class HomeController < ApplicationController

    def noncompliant 
        # Noncompliant: User input being used directly to open a file.
        content = open("./tmp_files/dir/%s" % params[:id], 'r').read
        render plain: content
    end

end
# {/fact}
