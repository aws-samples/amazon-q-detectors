#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-extend-custom-expression@v1.0 defects=1}
import re
from django.db.models.expressions import Func

# Noncompliant: Extending django custom expression which makes your application prone to sql-injection.
class Position(Func):
    function = 'POSITION'
    template = "%(function)s(? in %(expressions)s)"

    def __init__(self, expression, substring):
        super().__init__(expression, substring=self.sanitize_input(substring))

    def sanitize_input(self, input_string):
        return re.escape(str(input_string))
# {/fact}
