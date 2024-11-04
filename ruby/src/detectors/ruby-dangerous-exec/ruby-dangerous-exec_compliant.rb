# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-dangerous-exec@v1.0 defects=0}
def compliant()
    file_to_remove = "temp.txt" 

    # Compliant: `exec` doesn't have any external input.
    exec(["rm", "-rf", file_to_remove])
end
# {/fact}
