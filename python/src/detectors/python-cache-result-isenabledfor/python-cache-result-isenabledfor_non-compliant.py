#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-cache-result-isenabledfor@v1.0 defects=1}
import logging

def nonconformant_case():
    logger = logging.getLogger("MyLog")
    if logger.isEnabledFor(CUSTOM):
        # Noncompliant: `logger` level is not set.
        print("logging error : ", logger)
# {/fact}
