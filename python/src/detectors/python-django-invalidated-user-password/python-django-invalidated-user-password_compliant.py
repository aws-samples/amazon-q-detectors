#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-django-invalidated-user-password@v1.0 defects=0}
from django.http import HttpResponseBadRequest
from django.contrib.auth import get_user_model
from django.contrib.auth.password_validation import validate_password
from django.core.exceptions import ValidationError
import os

def compliant():
    user_profile = get_user_model()
    password = os.getenv("ENVIRONMENT_VARIABLE_VALUE")
    try:
        validate_password(password)
    except ValidationError as e:
        return HttpResponseBadRequest(str(e))
    # Compliant: Securely sets the user's password by validating the password before updating it, ensuring password strength and security.
    user_profile.set_password(password)
    user_profile.save()
# {/fact}
