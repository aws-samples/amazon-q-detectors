# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-dangerous-syscall@v1.0 defects=1}
def noncompliant
    # Noncompliant: `syscall` is used to execute an arbitrary system command.
    syscall 4, 1, "hello\n", 6
end
# {/fact}
