#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-dangerous-template-string@v1.0 defects=0}
from jinja2 import Environment
from fastapi import Request
import bleach

def conformant(request: Request):
    env = Environment(autoescape=True)
    sanitized_url = bleach.clean(
        str(request.url),
        tags=['div', 'h1', 'h3'],
        attributes={'*': ['class']},
        strip=True
    )
    template = f'''[  extends "index.html"  ]
        [ body  ]
        <div class="center-content">
        <h1>Non comformant test case.</h1>
        <h3>{sanitized_url}</h3>
        </div>
        [  end body  ]
        '''
    # Compliant: URL is sanitized before rendering, preventing XSS.
    return env.from_string(template)
# {/fact}
