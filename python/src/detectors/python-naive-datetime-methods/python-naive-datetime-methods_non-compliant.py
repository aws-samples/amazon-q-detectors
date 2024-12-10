#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-naive-datetime-methods@v1.0 defects=1}
from datetime import datetime

def noncompliant_utcnow():
    # Noncompliant: Uses naive `datetime` without timezone information.
    return datetime.utcnow()
# {/fact}
