#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-docker-arbitrary-container-run@v1.0 defects=0}
import docker
from flask import request
import html
from dockercred import img

client = docker.from_env()

def compliant(request):
    # Compliant: Sanitized user input is being passed in the argument for the Docker image.
    img = html.escape(request.args.get("image"))
    client.containers.run(img, 'echo hello world')
# {/fact}
