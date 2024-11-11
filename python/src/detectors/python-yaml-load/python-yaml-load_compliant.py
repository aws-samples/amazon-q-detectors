#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-yaml-load@v1.0 defects=0}
from django.http import HttpRequest, JsonResponse
import yaml

def yaml_load_compliant(request : HttpRequest):
    # Compliant: Used safe yaml load.
    result = yaml.load(request, Loader=yaml.CSafeLoader)
    yaml.dump(result)
# {/fact}
