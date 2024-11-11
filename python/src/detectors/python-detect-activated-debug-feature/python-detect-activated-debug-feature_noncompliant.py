#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-detect-activated-debug-feature@v1.0 defects=1}
from django.conf import settings

def detect_activated_debug_feature_noncompliant():
    # Noncompliant: The `DEBUG` feature is enabled.
    settings.configure(DEBUG=True)
# {/fact}
