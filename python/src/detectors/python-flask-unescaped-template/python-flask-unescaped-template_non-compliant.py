#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-flask-unescaped-template@v1.0 defects=1}
from flask import Flask
from flask import render_template
from flask import request

app = Flask(__name__)

@app.route("/non_compliant1")
def non_compliant():
    # Noncompliant: Unsanitized user input is being used with Flask template rendering methods.
    return render_template("unsafe.txt", name = "myname", age = request.args.get("age"))
# {/fact}
