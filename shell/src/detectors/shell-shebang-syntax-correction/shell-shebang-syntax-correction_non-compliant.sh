# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-shebang-syntax-correction@v1.0 defects=1}	 

# Noncompliant: There are spaces in between `#` and `!` in the shebang.
# !/bin/bash
echo "Hello Shell"

# {/fact}
