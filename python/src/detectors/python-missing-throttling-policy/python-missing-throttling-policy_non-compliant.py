#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-missing-throttling-policy@v1.0 defects=1}

# Noncompliant: `DEFAULT_THROTTLE_CLASSES` and `DEFAULT_THROTTLE_RATES` have not been set.
REST_FRAMEWORK = {
    'PAGE_SIZE': 10
}
# {/fact}
