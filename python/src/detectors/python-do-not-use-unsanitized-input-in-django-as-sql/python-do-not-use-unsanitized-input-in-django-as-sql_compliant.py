#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-use-unsanitized-input-in-django-as-sql@v1.0 defects=0}
from django.http import request
import bleach
from django.db import models
from django.db.models import Value

class Position(models.Func):
    function = 'POSITION'
    template = "%(function)s('%(substring)s' in %(expressions)s)"

    def __init__(self, expression, substring):
        super().__init__(expression, Value(substring))

    def compliant(self, compiler, connection):
        names_dict = request.POST.get('names_dict')
        # Compliant: Django custom expressions are constructed from sanitized user input.
        sanitized_names_dict = {k: bleach.clean(v) for k, v in names_dict.items()}
        sanitized_query_params = {k: connection.ops.quote_name(v) for k, v in sanitized_names_dict.items()}
        return super(Position, self).as_sql(compiler=compiler, connection=connection, extra_context=sanitized_query_params)
# {/fact}
