#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-disabled-html-auto-escape@v1.0 defects=0}
from jinja2 import Environment
from markupsafe import Markup

def compliant():
    # Compliant: Proper escaping and filtering enabled to prevent XSS.
    env = Environment(autoescape=True)
    env.filters['safe_markup'] = lambda x: Markup.escape(x)
    return env
# {/fact}
