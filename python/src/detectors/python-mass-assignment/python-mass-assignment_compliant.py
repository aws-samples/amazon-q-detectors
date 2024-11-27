#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-mass-assignment@v1.0 defects=0}

from django.shortcuts import render

def compliant(request):
    # Compliant: The code explicitly specifies the fields to be assigned values from user input, preventing mass assignment vulnerabilities.
    Whatzit.objects.create(
        name=request.POST.get('name'),
        dob=request.POST.get('dob')
    )
    return render(request, 'created.html')
# {/fact}
