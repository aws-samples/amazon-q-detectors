# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-file-disclosure@v1.0 defects=0}
def compliant 
    # Compliant: No assets have been made publicly available.
    config.serve_static_assets = false
end
# {/fact}
