#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-zip-bomb-attack@v1.0 defects=1}
import tarfile
from flask import Flask, request

app = Flask(__name__)

@app.route('/someUrl')
def zip_bomb_attack_noncompliant():
    user_file = request.files['file']
    filename = user_file.filename
    user_file.save(filename)
    tfile = tarfile.open(filename)
    # Noncompliant: Untrusted archive file extracted without any validation.
    tfile.extractall('./tmp/')
    tfile.close()
# {/fact}

