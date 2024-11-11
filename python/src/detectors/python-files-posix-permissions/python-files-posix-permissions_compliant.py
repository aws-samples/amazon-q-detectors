#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-files-posix-permissions@v1.0 defects=0}
import os
import stat

def change_file_permissions_compliant():
    # Compliant: Permissions assigned to owner and owner group.
    os.chmod("sample.txt", stat.S_IRWXU | stat.S_IRWXG)
# {/fact}
