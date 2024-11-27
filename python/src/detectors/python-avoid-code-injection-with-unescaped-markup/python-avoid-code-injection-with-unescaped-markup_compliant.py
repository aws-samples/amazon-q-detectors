#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-avoid-code-injection-with-unescaped-markup@v1.0 defects=0}
from flask import render_template, Markup
from flask_sqlalchemy import SQLAlchemy
from flask import Flask

app = Flask(__name__)
db = SQLAlchemy(app)

@app.route("/someurl")
def compliant1(request):
    content = request.args.get('content')
    # Compliant: User input escaped before rendering, preventing XSS.
    render_template("page.html", content=Markup.escape(content))
# {/fact}
