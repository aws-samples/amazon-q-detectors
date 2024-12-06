#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-aware-datetime-with-tzinfo@v1.0 defects=0}
from datetime import datetime, timezone

def conformant():
    # Compliant: `datetime` method specifies the `timezone`, avoiding the time zone related issues.
    return datetime.now(tz=timezone.utc)
# {/fact}
