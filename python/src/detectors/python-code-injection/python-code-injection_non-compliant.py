#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-code-injection@v1.0 defects=1}
import base64

def non_conformant_with_base64(request):
    if request.method == 'POST':
        var = base64.decodebytes(request.POST.get('first_name', ''))
        # Noncompliant: Uses the `exec` function to execute a dynamically constructed string, introducing a code injection vulnerability.
        exec("setname('%s')" % var)
# {/fact}
