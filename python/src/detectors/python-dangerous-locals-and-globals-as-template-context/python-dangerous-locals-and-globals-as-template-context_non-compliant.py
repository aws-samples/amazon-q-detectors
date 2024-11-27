#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-dangerous-locals-and-globals-as-template-context@v1.0 defects=1}
from django.shortcuts import render

def non_compliant(request):
    # Noncompliant: `globals()` used as context, exposing sensitive data.
    response = render(request, 'vulnerable/xss/form.html', globals())
    response.set_cookie(key='monster', value='omnomnomnomnom!', httponly=True)
    return response
# {/fact}
