# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-divide-by-zero@v1.0 defects=0}
def noncompliant 
    variable = 3
    zero = 0
    if zero != 0
        # Compliant: Prevent division by zero.
        value = variable / zero
    end
end
# {/fact}
