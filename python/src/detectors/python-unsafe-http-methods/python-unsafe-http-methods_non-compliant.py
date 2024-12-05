#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-unsafe-http-methods@v1.0 defects=1}
from django.http import HttpResponse
from django.views.decorators.http import require_http_methods

# Noncompliant: `@require_http_methods(["GET", "POST"])` allows both `GET` and `POST` requests, which may not be secure depending on the use case.
@require_http_methods(["GET", "POST"])
def django_non_compliant_http_methods_1(request):
    return HttpResponse("...")
# {/fact}
