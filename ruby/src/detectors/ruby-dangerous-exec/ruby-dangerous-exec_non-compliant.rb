# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-dangerous-exec@v1.0 defects=1}
def noncompliant()
    file_to_remove = params[:file_to_remove] 

    # Noncompliant: `exec` seems to have external input.
    exec(["rm", "-rf", file_to_remove])
end
# {/fact}
