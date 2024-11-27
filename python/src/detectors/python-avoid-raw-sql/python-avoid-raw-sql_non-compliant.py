#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-avoid-raw-sql@v1.0 defects=1}

def non_compliant(request, Person):
    lname = request.GET.get('last_name')
    # Noncompliant: The sql query below uses raw string concatenation which could lead to SQL injection attacks.
    query = 'SELECT * FROM myapp_person WHERE last_name = %s' % lname
    Person.objects.raw(query)

# {/fact}
