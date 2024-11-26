#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-avoid-app-run-with-bad-host@v1.0 defects=0}
from flask import Flask

# Compliant: The app with default host which does not expose the server to the public.
app = Flask(__name__)

app.run()
# {/fact}
