#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-django-query-set-extra@v1.0 defects=1}
def non_conformant(request):
    name = request.data.get('name')
    user_name = request.data.get('user_name')
    # Noncompliant: Unparameterized SQL query, which could lead to SQL injection.
    qs = qs.objects.defer(name).extra(where=['name = {}'.format(user_name)])
# {/fact}
