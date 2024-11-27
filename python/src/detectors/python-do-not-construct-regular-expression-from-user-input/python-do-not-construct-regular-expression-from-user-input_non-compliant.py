#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-construct-regular-expression-from-user-input@v1.0 defects=1}
import re

def django_non_compliant(request):
    # Noncompliant: The `username` is used directly in the regular expression without escaping, making it vulnerable to regex injection attacks.
    username = request.POST.get('username')
    filename = request.FILES['filename'].name
    re.search(username,filename)
# {/fact}
