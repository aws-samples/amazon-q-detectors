#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-avoid-using-blank-password@v1.0 defects=1}
from models import UserProfile
from backend import EmailAuthBackend

def non_compliant(user_profile: UserProfile) -> None:
    # Noncompliant: Password makes the brute-force attack against the login interface much easier.
    password = ""
    user_profile.set_password(password)
    user_profile.save()
    self.assertIsNone(EmailAuthBackend().authenticate(username=self.example_email('hamlet'), password=password))

# {/fact}
