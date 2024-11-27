#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-django-invalidated-user-password@v1.0 defects=1}
from django.contrib.auth import get_user_model

def non_compliant():
    user_profile = get_user_model()
    # Noncompliant: Sets the user's password without any validation, potentially allowing weak or insecure passwords, compromising account security.
    user_profile.set_password("testpassword")
    user_profile.save()
# {/fact}
