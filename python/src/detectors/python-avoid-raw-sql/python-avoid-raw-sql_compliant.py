#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-avoid-raw-sql@v1.0 defects=0}
from django.db.models.expressions import RawSQL

def compliant(request, queryset):
    someparam = request.GET.get("name")
    # Compliant: Raw string concatenation has been avoided and a parameterized query has been used instead.
    queryset.annotate(val=RawSQL("select col from sometable where othercol = %s", (someparam,)))

# {/fact}
