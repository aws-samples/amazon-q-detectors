#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-csrf-disabled@v1.0 defects=1}
from flask import Flask

def csrf_protection_noncompliant():
    app = Flask(__name__)
    # Noncompliant: CSRF protection is disabled.
    app.config['WTF_CSRF_ENABLED'] = False
# {/fact}
