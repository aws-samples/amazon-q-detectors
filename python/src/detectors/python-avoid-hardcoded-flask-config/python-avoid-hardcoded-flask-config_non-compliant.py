#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-avoid-hardcoded-flask-config@v1.0 defects=1}
import flask
import os

app = flask.Flask(__name__)

# Noncompliant: Flask configuration is hardcoded.
app.config["DEBUG"] = True

# {/fact}
