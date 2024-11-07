# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-file-permissions@v1.0 defects=0}
require "fileutils"

def compliant(filename)
    # Compliant: Only owner has read and write permissions.
    FileUtils.chmod 0600, filename
end
# {/fact}
