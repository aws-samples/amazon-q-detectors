# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-zip-slip@v1.0 defects=1}
import zipfile
from flask import Flask

app = Flask(__name__)

def non_compliant(archive_name):
    zf = zipfile.ZipFile(archive_name)
    # Noncompliant: Expanding an archive file without validating is vulnerable to a zip slip attack.
    zf.extractall(".")
    zf.close()
# {/fact}
