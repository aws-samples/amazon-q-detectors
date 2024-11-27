#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-file-injection@v1.0 defects=0}
import html
from flask import Flask, request
app = Flask(__name__)

@app.route("/someurl")
def compliant():
    file_data = request.args["file_data"]
    # Compliant: User input is sanitized before passing to `write()`.
    sanitized_data = html.escape(file_data)
    with open("somefile.txt", "a") as file:
        file.write(sanitized_data)
# {/fact}
