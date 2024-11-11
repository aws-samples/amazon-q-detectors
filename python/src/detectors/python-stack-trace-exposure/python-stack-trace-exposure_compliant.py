#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-stack-trace-exposure@v1.0 defects=0}
from flask import Flask, jsonify
from werkzeug.exceptions import HTTPException

app_flask = Flask(__name__)

@app_flask.route('/compliant/<text>')
def stack_trace_exposure_compliant(text):
    try:
        if text == 'error':
            raise HTTPException
        return jsonify({'data': 'some_data'}), 200
    except HTTPException:
        # Compliant: Custom JSON response with message will avoid exposing stack trace.
        return jsonify({'message': 'Internal error occurred!'}), 404
# {/fact}
