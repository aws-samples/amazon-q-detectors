#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-incorrect-equality-operator@v1.0 defects=1}

# Noncompliant: Incorrect assignment using `==`.
count==0
while [ $count -lt 5 ]; do
    echo $count
    count=$((count + 1))
done

# {/fact}
