#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-class-extends-safe-string@v1.0 defects=0}
from django.utils.html import mark_safe

# Compliant: Use `mark_safe()` function instead of directly inheriting from `SafeString`.
class SafeContent:
    def __init__(self, content):
        self._content = mark_safe(str(content))
    
    def __str__(self):
        return self._content
    
    def __repr__(self):
        return repr(self._content)
# {/fact}
