#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-file-extension-validation@v1.0 defects=0}
import os
from flask import Flask, request

app = Flask(__name__)

debug_mode = os.environ.get('FLASK_DEBUG', 'False').lower() == 'true'

app.config.update(
    DEBUG=debug_mode,
)

@app.route('/', methods=['GET', 'POST'])
def compliant():
    extensions = {'txt', 'pdf', 'png', 'jpg', 'jpeg', 'gif'}
    file = request.files['file']
    # Compliant: The uploaded file must have one of the allowed extensions.
    if '.' in file.filename and file.filename.split('.')[-1] in extensions:
        file.save(os.path.join(app.config['UPLOAD_FOLDER'], file.filename))
# {/fact}
