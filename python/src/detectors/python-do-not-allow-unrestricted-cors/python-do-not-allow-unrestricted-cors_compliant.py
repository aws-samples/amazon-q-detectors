#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-allow-unrestricted-cors@v1.0 defects=0}
from flask import app, request, Flask
from flask_cors import CORS

app = Flask(__name__)
# Compliant: The `send_wildcard` is set to allow only a specific list of trusted domains.
CORS(app, send_wildcard=False)
# {/fact}
