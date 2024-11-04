# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-file-disclosure@v1.0 defects=1}
def noncompliant 
    # Noncompliant: Giving access to static assets could lead to the exposure of sensitive information.
    config.serve_static_assets = true
  end
# {/fact}
