# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-file-leak@v1.0 defects=0}
def compliant(filename)
    # Compliant: Files correctly opened using a `do` statement.
    File.open(filename, 'r') do |file|
        file.each_line do |line|
            puts line
        end
    end
end
# {/fact}
