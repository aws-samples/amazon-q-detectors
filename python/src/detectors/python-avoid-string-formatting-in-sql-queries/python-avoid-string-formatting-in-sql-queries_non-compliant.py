#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-avoid-string-formatting-in-sql-queries@v1.0 defects=1}
from flask import Flask, request
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)
db = SQLAlchemy(app)

@app.route("/someurl")
def flask_non_conformant_1():
    name = request.args.get("name")
    # Noncompliant: User input directly concatenated in SQL query, making it vulnerable to SQL injection attacks.
    db.engine.execute("SELECT * FROM Users WHERE name = %s" % name)
# {/fact}
