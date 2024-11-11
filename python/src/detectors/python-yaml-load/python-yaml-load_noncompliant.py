#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-yaml-load@v1.0 defects=1}
from django.http import HttpRequest, JsonResponse
import yaml

def yaml_load_noncompliant(request : HttpRequest):
    # Noncompliant: Unsafe yaml load is used.
    result = yaml.load(request)
    yaml.dump(result)
# {/fact}
