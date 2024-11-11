#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-avoid-jsonpickle@v1.0 defects=0}
import jsonpickle

def untrusted_deserialization_compliant():
    userobj = input("user")
    allowed_user_obj = ['example_module1', 'example_module2']
    # Compliant: Untrusted object is validated before deserialization.
    if userobj in allowed_user_obj:
        obj = jsonpickle.decode(userobj)
        return obj
# {/fact}
