#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-integer-overflow@v1.0 defects=0}
import numpy as np

def integer_overflow_compliant():
    # Compliant: Number stored is within the limits of the specified datatype.
    arr = np.array([100000000], dtype=np.int32)
# {/fact}
