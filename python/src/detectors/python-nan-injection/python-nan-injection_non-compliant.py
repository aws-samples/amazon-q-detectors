#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-nan-injection@v1.0 defects=1}
from datetime import datetime
from datetime import timezone

def django_non_compliant(request):
    id = request.POST.get("id")

    price = get_price()

    # Noncompliant: 'id' is converted to a float, which can lead to unexpected behavior.
    x = float(id)

    if x < price:
        return deny()
    return buy()

def get_price():
    return 100.0

def buy():
    return {
        'transaction_id': 'TXN_' + str(datetime.now(timezone.utc).timestamp()),
        'status': 'completed'
    }

def deny():
    return {
        'reason': 'Insufficient funds',
        'timestamp': datetime.now(timezone.utc)
    }
# {/fact}
