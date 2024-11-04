# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-force-ssl-false@v1.0 defects=0}
def compliant 
    # Compliant: force_ssl is explicitly set to 'true'.
    config.force_ssl = true 
end
# {/fact}
