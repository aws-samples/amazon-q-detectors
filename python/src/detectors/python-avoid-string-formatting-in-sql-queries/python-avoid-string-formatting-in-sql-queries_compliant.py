#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-avoid-string-formatting-in-sql-queries@v1.0 defects=0}
from flask import Flask, request
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)
db = SQLAlchemy(app)

@app.route("/someurl")
def flask_conformant_1():
    name = request.args.get("name")
    # Compliant: Parameterized SQL query to prevent SQL injection attacks.
    db.engine.execute("SELECT * FROM Users WHERE name = %s", name)
# {/fact}
