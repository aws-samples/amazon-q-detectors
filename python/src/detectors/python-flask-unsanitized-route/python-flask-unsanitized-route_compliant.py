#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-flask-unsanitized-route@v1.0 defects=0}
from html import escape
from flask import Flask
from flask import request

app = Flask(__name__)

@app.route('/hello2')
def compliant():
    name = request.args.get('name')
    # Compliant: `Flask.route` is returning a formatted string with sanitized user input.
    respones = '<h1>Hello, {}</h1>'.format(escape(name))
    return respones
# {/fact}
