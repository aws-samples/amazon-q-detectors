#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-extend-custom-expression@v1.0 defects=0}
from django.db.models import Value
import psycopg2.sql as sql
from django.db import models

class Position(models.Func):
    function = 'POSITION'
    template = "%(function)s('%(substring)s' in %(expressions)s)"

    def __init__(self, expression, substring):
        super().__init__(expression, Value(substring))
        
    # Compliant: Sanitized user input is being used while extending django custom expression.
    def sanitize_input(self, input_string):
        return sql.SQL(self.template).format(
            function=sql.SQL(self.function),
            expressions=sql.SQL(', ').join([sql.Literal(str(input_string))])
        )
# {/fact}
