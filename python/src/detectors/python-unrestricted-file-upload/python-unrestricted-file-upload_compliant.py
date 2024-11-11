#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-unrestricted-file-upload@v1.0 defects=0}
import os
from flask import Flask, request

app = Flask(__name__)

@app.route('/', methods=['GET', 'POST'])
def file_upload_compliant():
    extensions = {'txt', 'pdf', 'png', 'jpg', 'jpeg', 'gif'}
    upload_file = request.files['file']
    # Compliant: The uploaded file must have one of the allowed extensions.
    if '.' in upload_file.filename and \
            upload_file.filename.split('.')[-1] in extensions:
        upload_file.save(os.path.join('/path/to/the/uploads',
                                      upload_file.filename))
# {/fact}
