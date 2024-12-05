#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-django-query-set-extra@v1.0 defects=0}
def conformant(request):
    title = request.data.get('title')
    # Compliant: Use parameterized extra with separate params.
    qs = qs.objects.filter(title__icontains=title).extra(select={'name': 'Django'})
# {/fact}
