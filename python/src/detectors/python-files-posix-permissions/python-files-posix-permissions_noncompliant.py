#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-files-posix-permissions@v1.0 defects=1}
import os
import stat

def change_file_permissions_noncompliant():
    # Noncompliant: Permissions assigned to all users.
    os.chmod("sample.txt", stat.S_IRWXU | stat.S_IRWXG | stat.S_IRWXO)
# {/fact}
