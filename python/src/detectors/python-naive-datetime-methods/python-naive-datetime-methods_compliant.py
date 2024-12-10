#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-naive-datetime-methods@v1.0 defects=0}
from datetime import datetime, timezone

def compliant_utcnow():
    t1 =  datetime.utcnow()
    # Compliant: Uses timezone-aware `datetime` by setting `tzinfo`.
    t2 = t1.replace(tzinfo=timezone.utc)
    print(t2)
# {/fact}
