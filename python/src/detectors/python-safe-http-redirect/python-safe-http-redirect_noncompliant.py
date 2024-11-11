#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-safe-http-redirect@v1.0 defects=1}
from flask import Flask
from flask import request, redirect

app = Flask(__name__)

@app.route('/redirect')
def redirect_url_noncompliant():
    endpoint = request.args['url']
    # Noncompliant: Redirect to a user-supplied URL without sanitization.
    return redirect(endpoint)
# {/fact}
