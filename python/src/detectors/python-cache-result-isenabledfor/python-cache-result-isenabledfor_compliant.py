#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-cache-result-isenabledfor@v1.0 defects=0}
import logging

def conformant_case():
    logger = logging.getLogger("MyLog")
    lg = logger.isEnabledFor(logging.INFO)
    if lg:
        # Compliant: `logger` level is set.
        print("logging error : ", logger)
# {/fact}
