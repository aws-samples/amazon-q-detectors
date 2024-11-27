#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-dangerous-locals-and-globals-as-template-context@v1.0 defects=0}
from django.shortcuts import render

def compliant(request):
    # Compliant: Safe context object used for rendering.
    response = render(request, 'vulnerable/xss/form.html', dict())
    response.set_cookie(key='monster', value='omnomnomnomnom!', httponly=True)
    return response
# {/fact}
