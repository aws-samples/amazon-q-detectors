#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-dangerous-template-string@v1.0 defects=1}
from jinja2 import Environment
from fastapi import Request

def non_conformant(request: Request):
    env = Environment(autoescape=True)
    template = f'''[  extends "index.html"  ]
        [ body  ]
        <div class="center-content">
        <h1>Non comformant test case.</h1>
        <h3>{request.url}</h3>
        </div>
        [  end body  ]
        '''
    # Noncompliant: URL is rendered without sanitization, leading to potential XSS vulnerabilities.
    return env.from_string(template)
# {/fact}
