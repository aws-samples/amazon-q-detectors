# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-force-ssl-false@v1.0 defects=1}
def noncompliant 
    # Noncompliant: `force_ssl` set to `false`.
    config.force_ssl = false
end
# {/fact}
