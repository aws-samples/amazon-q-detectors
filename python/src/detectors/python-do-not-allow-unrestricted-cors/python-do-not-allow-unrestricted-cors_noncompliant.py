#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-allow-unrestricted-cors@v1.0 defects=1}
from flask import Flask
from flask_cors import CORS

app = Flask(__name__)
# Noncompliant: The `send_wildcard` is set to allow any domain.
CORS(app, send_wildcard=True)
# {/fact}
