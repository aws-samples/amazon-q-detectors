#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-flask-unsanitized-route@v1.0 defects=1}
from flask import Flask
from flask import request

app = Flask(__name__)

@app.route('/hello')
def non_conformant():
    name = request.args.get('name')
    # Noncompliant: `Flask.route` is returning a formatted string with unsanitized user input.
    return '<h1>Hello, %s</h1>' % name 
# {/fact}
