#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-avoid-app-run-with-bad-host@v1.0 defects=1}
from flask import Flask

app = Flask(__name__)

# Noncompliant: The app uses the host 0.0.0.0, which exposes the server to the public.
if __name__ == '__main__':
    app.run(host="0.0.0.0")

# {/fact}
