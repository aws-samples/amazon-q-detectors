#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-use-unsanitized-input-in-django-as-sql@v1.0 defects=1}
from django.db.models import Func, Value, F
from django.http import request

class ConcatName(Func):
    def non_compliant(self, compiler, connection):
        names_dict = request.POST.get('names_dict')
        sanitized_dict = {k: connection.ops.quote_name(connection.ops.quote_name(v)) for k, v in names_dict.items()}
        # Noncompliant: Django custom expressions are constructed from unsanitized user input.
        return super(ConcatName, self).as_sql(compiler=compiler, connection=connection, extra_context=sanitized_dict)
# {/fact}
