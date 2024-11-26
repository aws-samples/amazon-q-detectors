#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-avoid-raw-sql@v1.0 defects=0}
from django.db.models.expressions import RawSQL
from django.http import request

def compliant(queryset):
    someparam = request.GET.get("name")
    # Compliant: `RawSQL` or `raw` is not present.
    queryset.annotate(val=RawSQL("select col from sometable where othercol = %s", (someparam,)))

# {/fact}
