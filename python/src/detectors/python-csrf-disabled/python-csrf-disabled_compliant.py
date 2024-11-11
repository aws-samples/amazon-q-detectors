#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-csrf-disabled@v1.0 defects=0}
from flask_wtf.csrf import CSRFProtect
from flask import Flask

def csrf_protection_compliant():
    app = Flask(__name__)
    csrf = CSRFProtect(app)
    # Compliant: CSRF protection is enabled.
    csrf.init_app(app)
# {/fact}
