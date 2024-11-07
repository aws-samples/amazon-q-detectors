#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
	 
# {fact rule=shell-incorrect-conditional-syntax@v1.0 defects=0}

# Compliant: Uses `elif` for proper alternative condition checking in shell scripts.
if [ "$fruit" = "apple" ]
then
    echo "It's an apple"
elif [ "$fruit" = "banana" ]
then
    echo "It's a banana"
else
    echo "It's something else"
fi

# {/fact}
