#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-http-unsanitized-inputs@v1.0 defects=1}
from flask import render_template, request, redirect, url_for, make_response, app, Response

@app.route('/setCookie')
def non_compliant():
    value = request.args["val"]
    response = make_response(render_template('index.html'))
    # Noncompliant: Unsanitized input is being used to create a `Cookie`.
    response.set_cookie("val", value, httponly=True)
    return response
# {/fact}
