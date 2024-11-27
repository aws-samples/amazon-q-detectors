#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-file-extension-validation@v1.0 defects=1}
import os
from flask import Flask, request

app = Flask(__name__)

@app.route('/', methods=['GET', 'POST'])
def non_conformant_1():
    file = request.files['file']
    # Noncompliant: The uploaded file can have any extension.
    file.save(os.path.join(app.config['UPLOAD_FOLDER'], file.filename))
# {/fact}
