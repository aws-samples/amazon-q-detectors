#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-unrestricted-file-upload@v1.0 defects=1}
import os
from flask import Flask, request

app = Flask(__name__)

@app.route('/', methods=['GET', 'POST'])
def file_upload_non_compliant():
    upload_file = request.files['file']
    # Noncompliant: The uploaded file can have any extension.
    upload_file.save(os.path.join('/path/to/the/uploads',
                                  upload_file.filename))
# {/fact}
