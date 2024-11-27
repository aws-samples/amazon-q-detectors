#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-set-is-safe-to-true-in-django-filters@v1.0 defects=1}
from django.template import Library
from django.utils.html import conditional_escape
from django.utils.safestring import mark_safe, mark_for_escaping

register = Library()

# Noncompliant: The `is_safe` flag is `True`, potentially exposing the app to XSS vulnerabilities.
@register.filter(is_safe=True, needs_autoescape=False)
def non_compliant(value, arg):
    result = value.replace(arg, '')
    return result
# {/fact}
