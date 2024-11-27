#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-construct-regular-expression-from-user-input@v1.0 defects=0}
import re

def django_compliant(request):
    # Compliant: The `re.escape()` function is used to escape special characters in the username, preventing potential regex injection attacks.
    username = re.escape(request.POST.get('username'))
    filename = request.FILES['filename'].name
    re.search(username,filename)
# {/fact}
