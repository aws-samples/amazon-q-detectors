#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-avoid-path-traversal@v1.0 defects=0}
from flask import request, Flask

app = Flask(__name__)

@app.route('/someurl')
def verify_file_path_compliant():
    base_path = "/var/data/images/"
    file_path = request.args["file"]
    allowed_path = ["example_path1", "example_path2"]
    # Compliant: User input file path is validated before use.
    if file_path in allowed_path:
        file = open(base_path + file_path)
        file.close()
# {/fact}
