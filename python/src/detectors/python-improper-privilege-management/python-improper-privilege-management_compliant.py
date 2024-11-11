#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-improper-privilege-management@v1.0 defects=0}
import os

def set_user_compliant():
    userid = 4
    # Compliant: The process user is set to `userid` 4.
    os.setuid(userid)
# {/fact}
