# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-expect-and-raise-exception@v1.0 defects=0}
import logging

def compliant():
    try:
        print("Some Operation...")
    # Compliant: Catching and re-throwing an exception with performing additional operations.
    except KeyError as e:
        logging.exception('An error occurred during execution', e, stack_info=True, exc_info=True)
        raise
# {/fact}
