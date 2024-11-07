#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-non-portable-character-class@v1.0 defects=0}

# Compliant: Uses `[:upper:]` and `[:lower:]` to properly handle all case conversions.
uppercase_name=$(echo "JOSE" | tr '[:upper:]' '[:lower:]' | tr '[:lower:]' '[:upper:]')

# {/fact}
