#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-extend-custom-expression@v1.0 defects=0}

from django.db.models import Value

# Compliant: Sanitized user input is being used while extending django custom expression.
class Position(models.Func):
    function = 'POSITION'
    template = "%(function)s('%(substring)s' in %(expressions)s)"

    def __init__(self, expression, substring):
        super().__init__(expression, Value(substring))
# {/fact}
