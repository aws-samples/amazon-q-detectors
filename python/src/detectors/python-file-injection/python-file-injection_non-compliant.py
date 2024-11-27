#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-file-injection@v1.0 defects=1}
from flask import Flask, request
app = Flask(__name__)

@app.route("/someurl")
def non_compliant():
    file_data = request.args["file_data"]
    with open("somefile.txt", "a") as file:
        # Noncompliant: Untrusted user input is passed to `write()`.
        file.write(file_data)
# {/fact}
