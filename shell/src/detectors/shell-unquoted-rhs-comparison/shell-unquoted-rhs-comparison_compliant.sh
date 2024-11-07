#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-unquoted-rhs-comparison@v1.0 defects=0}

# Compliant: Quoted RHS prevents glob interpretation, ensuring exact string comparison.
password="my[pass]word"
if [[ $entered_password = "$password" ]]; then
    echo "Password correct"
fi

# {/fact}
