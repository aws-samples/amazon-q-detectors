#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-mass-assignment@v1.0 defects=1}

from django.shortcuts import render

def non_compliant(request):
    # Noncompliant: The code unpacks the user input directly into the create() method, allowing any field or related object to be set, leading to potential mass assignment vulnerabilities.
    Whatzit.objects.create(**request.POST)
    return render(request, 'created.html')
# {/fact}
