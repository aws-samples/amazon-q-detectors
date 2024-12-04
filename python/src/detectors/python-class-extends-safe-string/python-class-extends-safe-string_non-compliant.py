#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-class-extends-safe-string@v1.0 defects=1}
from django.utils.safestring import SafeString

# Noncompliant: Inheriting directly from SafeString can bypass Django's built-in escaping mechanisms, potentially introducing security vulnerabilities.
class IWantToBypassEscaping(SafeString):
    def __init__(self):
        super().__init__()
# {/fact}
