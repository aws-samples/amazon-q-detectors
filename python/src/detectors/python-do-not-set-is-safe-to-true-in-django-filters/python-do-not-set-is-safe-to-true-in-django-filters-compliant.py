#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-set-is-safe-to-true-in-django-filters@v1.0 defects=0}
from django.template import Library
from django.utils.html import conditional_escape
from django.utils.safestring import mark_safe, mark_for_escaping

# Compliant: The `is_safe` flag is `False`, preventing potential XSS vulnerabilities.
@register.filter(is_safe=False, needs_autoescape=False)
def compliant(value):
    result = '<strong>' + value + '</strong>'
    return result
# {/fact}
