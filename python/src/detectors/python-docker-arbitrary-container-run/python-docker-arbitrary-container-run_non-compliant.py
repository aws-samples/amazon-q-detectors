#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-docker-arbitrary-container-run@v1.0 defects=1}
import docker
client = docker.from_env()
from flask import request

@app.route('/someUrl')
def non_compliant(request):
    img = request.args.get("image")
    # Noncompliant: Unsanitized user input is being used in the argument for the Docker image.
    client.containers.create(img, 'echo non compliant')
# {/fact}
