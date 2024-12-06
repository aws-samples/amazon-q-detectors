#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-aware-datetime-with-tzinfo@v1.0 defects=1}
from datetime import datetime

def non_conformant():
    # Noncompliant: `datetime` method does not specify `timezone`, resulting in time zone related issues.
    return datetime.now()
# {/fact}
