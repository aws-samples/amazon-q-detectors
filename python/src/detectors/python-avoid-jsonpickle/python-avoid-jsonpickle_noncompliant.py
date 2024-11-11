#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-avoid-jsonpickle@v1.0 defects=1}
import jsonpickle

def untrusted_deserialization_noncompliant():
    userobj = input("user")
    # Noncompliant: Untrusted object deserialized without validation.
    obj = jsonpickle.decode(userobj)
    return obj
# {/fact}
