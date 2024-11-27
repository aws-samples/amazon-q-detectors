#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-avoid-using-blank-password@v1.0 defects=0}
from django.contrib.auth.models import User

def compliant(request):
    if request.method == 'POST':
        username = request.POST['username']
        password = request.POST['password']

        user_profile = User.objects.get_or_create(username=username)

        # Compliant: Preventing usage of blank passwords mitigates brute-force attacks to some extent.
        if password != '':
            user_profile.set_password(password)
            user_profile.save()
# {/fact}
