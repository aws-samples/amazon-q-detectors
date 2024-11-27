#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-avoid-using-blank-password@v1.0 defects=1}
from django.contrib.auth.models import User

def non_compliant(request ):
    if request.method == 'POST':
        username = request.POST['username']
        password = ""

        user_profile = User.objects.get_or_create(username=username)

        # Noncompliant: Setting a blank password makes the brute-force attack against the login interface much easier.
        user_profile.set_password(password)
        user_profile.save()
# {/fact}
