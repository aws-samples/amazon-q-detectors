#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-constant-comparison@v1.0 defects=0}

# Compliant: Correctly compares the value of `$count` with `5`.
if [ "$count" -eq 5 ]
then
  echo "Count is 5"
fi

# {/fact}
