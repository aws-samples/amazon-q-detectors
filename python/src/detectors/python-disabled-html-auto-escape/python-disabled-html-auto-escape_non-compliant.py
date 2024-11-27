 #  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-disabled-html-auto-escape@v1.0 defects=1}
from jinja2 import Environment

def non_compliant():
    # Noncompliant: Automatic escaping disabled, leaving it vulnerable to XSS.
    Environment(autoescape=False)
# {/fact}
