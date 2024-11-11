#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-avoid-path-traversal@v1.0 defects=1}
from flask import request, Flask

app = Flask(__name__)

@app.route('/someurl')
def verify_file_path_noncompliant():
    file_path = request.args["file"]
    # Noncompliant: User input file path is not validated or sanitized.
    file = open(file_path)
    file.close()
# {/fact}
