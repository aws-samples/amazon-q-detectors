#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-stack-trace-exposure@v1.0 defects=1}
from flask import Flask, jsonify
from werkzeug.exceptions import HTTPException
import traceback

app_flask = Flask(__name__)

@app_flask.route('/noncompliant/<text>')
def stack_trace_exposure_noncompliant(text):
    try:
        if text == 'error':
            raise HTTPException
        return jsonify({'data': 'some_data'}), 200
    except HTTPException:
        # Noncompliant: Stack trace is returned from api call.
        return traceback.format_exc()
# {/fact}
