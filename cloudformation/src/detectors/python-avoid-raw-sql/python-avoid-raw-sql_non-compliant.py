#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-avoid-raw-sql@v1.0 defects=1}
from django.http import request

def non_compliant(Person):
    lname = request.GET.get('last_name')
    # Noncompliant: `RawSQL` or `raw` is present which indicates the execution of a non-parameterized SQL query.
    query = 'SELECT * FROM myapp_person WHERE last_name = %s' % lname
    Person.objects.raw(query)

# {/fact}
