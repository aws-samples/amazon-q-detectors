#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-detect-activated-debug-feature@v1.0 defects=0}
from django.conf import settings
import os

def detect_activated_debug_feature_compliant():
    # Compliant: The `DEBUG` feature is set through the environment variable.
    settings.configure(DEBUG=os.environ['DEBUG'])
# {/fact}
