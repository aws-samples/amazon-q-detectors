# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-assignment-to-global@v1.0 defects=1}
WIDTH = 0
HEIGHT = 0

def non_compliant(w, h):
    # Noncompliant: Global variables are dangerous as they frequently result in bugs.
    global WIDTH
    global HEIGHT
    WIDTH = w
    HEIGHT = h
    return WIDTH * HEIGHT
# {/fact}
