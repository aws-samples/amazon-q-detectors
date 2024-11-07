# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-file-leak@v1.0 defects=1}
def noncompliant(filename)
    # Noncompliant: Using a variable assignment to open a file.
    file = File.open(filename, 'r')
    contents = file.read
    puts contents
end
# {/fact}
