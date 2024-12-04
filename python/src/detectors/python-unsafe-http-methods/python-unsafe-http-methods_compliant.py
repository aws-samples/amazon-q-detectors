#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-unsafe-http-methods@v1.0 defects=0}
from django.http import HttpResponse
from django.views.decorators.http import require_http_methods

# Compliant: `@require_http_methods(["POST"])` restricts the view to only accept `POST` requests.
@require_http_methods(["POST"])
def django_compliant_http_post_method():
    return HttpResponse("...")
# {/fact}
