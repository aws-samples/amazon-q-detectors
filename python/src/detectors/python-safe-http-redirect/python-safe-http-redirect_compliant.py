#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-safe-http-redirect@v1.0 defects=0}
from flask import Flask
from flask import request, url_for, redirect

app = Flask(__name__)

@app.route('/redirect')
def redirect_url_compliant():
    endpoint = request.args['url']
    allowed = ['url1', 'url2']
    # Compliant: User-supplied URL is validated before redirecting to it.
    if endpoint in allowed:
        return redirect(endpoint)
# {/fact}
