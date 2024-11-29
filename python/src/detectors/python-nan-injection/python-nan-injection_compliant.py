#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-nan-injection@v1.0 defects=0}
from datetime import datetime
from datetime import timezone

def django_compliant(request):
    id = request.POST.get("id")

    if id.lower() == "nan":
        raise ValueError
    
    # Compliant: Validates input before conversion and ensures sequential error handling.
    num = float(id)
    if num > get_price():
        buy()
    deny()

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
