#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-sensitive-bourne-shells@v1.0 defects=1}

# Noncompliant: Missing space before `]]` in conditional expression.
while [[ "$COUNT" -lt 10]]; do
  echo "$COUNT"
  ((COUNT++))
done

# {/fact}