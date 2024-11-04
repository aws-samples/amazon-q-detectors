# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-file-permissions@v1.0 defects=1}
require "fileutils"

def noncompliant(filename)
    # Noncompliant: Setting file to world writable. Could lead to insecure file access.
    FileUtils.chmod 0222, filename
end
# {/fact}
