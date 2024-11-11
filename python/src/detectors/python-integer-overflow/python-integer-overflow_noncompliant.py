#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-integer-overflow@v1.0 defects=1}
import numpy as np

def integer_overflow_noncompliant():
    # Noncompliant: Number larger than limit of the datatype is stored.
    arr = np.array([100000000], dtype=np.int8)
# {/fact}
