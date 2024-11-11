#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-zip-bomb-attack@v1.0 defects=0}
import tarfile
from flask import Flask, request

app = Flask(__name__)

@app.route('/someUrl')
def zip_bomb_attack_compliant():
    user_file = request.files['file']
    filename = user_file.filename
    user_file.save(filename)
    tfile = tarfile.open(filename)
    threshold_entries = 100
    # Compliant: Untrusted archive file is validated before extraction.
    if len(tfile.getmembers()) < threshold_entries:
        tfile.extractall('./tmp/')
    tfile.close()
# {/fact}
