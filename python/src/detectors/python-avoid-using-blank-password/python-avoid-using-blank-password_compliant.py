#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-avoid-using-blank-password@v1.0 defects=0}
from django.template import RequestContext

def compliant(request):
    context = RequestContext(request)
    registered = False
    if request.method == 'POST':
        password = request.POST['password']
    # Compliant: Unusable Password does not allow the brute-force attack against the login interface much easier.
    if password != '' :
      user_profile.save()
      user_profile.set_password(password)
      user_profile.save()

# {/fact}
