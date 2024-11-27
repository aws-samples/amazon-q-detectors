#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-flask-unescaped-template@v1.0 defects=0}
from flask import Flask
from flask import render_template
from flask import request
from flask import escape

app = Flask(__name__)

@app.route("/compliant")
def compliant():
    # Compliant: Sanitized user input is being used with Flask template rendering methods.
    return render_template("unsafe.txt", name="myname", age=escape(request.args.get("age")))
# {/fact}
