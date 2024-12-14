#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-avoid-hardcoded-flask-config@v1.0 defects=0}
import flask

app = flask.Flask(__name__)

# Compliant: Variable `DEBUG` is fetched from environment.
app.config["DEBUG"] = os.environ["DEBUG"]

# {/fact}