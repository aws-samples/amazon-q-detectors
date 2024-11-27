#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-avoid-code-injection-with-unescaped-markup@v1.0 defects=1}
from flask import render_template
from markupsafe import Markup
from flask_sqlalchemy import SQLAlchemy
from flask import Flask

app = Flask(__name__)
db = SQLAlchemy(app)

@app.route("/someurl")
def non_compliant(request):
    content = request.args.get('content')
    # Noncompliant: User input rendered without escaping, vulnerable to XSS.
    render_template("/page.html", content=Markup(content))
# {/fact}
