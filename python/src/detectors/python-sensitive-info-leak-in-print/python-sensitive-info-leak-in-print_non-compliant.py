#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-sensitive-info-leak-in-print@v1.0 defects=1}
secret = "i should not print secrets"

def non_conformant(user):
    print("User Name:" + user.userName)
    print("Email Id: " + user.emailId)
    # Noncompliant: The code is vulnerable to data leaks by printing sensitive information, such as secrets or credentials.
    print("Secret Information : " + secret)
    print("User address : " + user.address)
# {/fact}
