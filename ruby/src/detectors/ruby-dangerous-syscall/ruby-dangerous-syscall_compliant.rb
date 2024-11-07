# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-dangerous-syscall@v1.0 defects=0}
def compliant
    # Compliant: Normal operation which avoids `syscall`.
    puts "hello"
end
# {/fact}
