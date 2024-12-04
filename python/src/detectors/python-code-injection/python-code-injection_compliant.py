#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-code-injection@v1.0 defects=0}
import base64

def conformant_with_base64(request):
    if request.method == 'POST':
        var = base64.decodebytes(request.POST.get('first_name', ''))
        # Compliant: Uses the `setname` function directly with the decoded value, avoiding code injection vulnerabilities.
        setname(var)
# {/fact}
