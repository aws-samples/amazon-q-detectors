# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-shebang-placement@v1.0 defects=1}

# Noncompliant: Shebang is not on the first line, making it ineffective.
#!/bin/bash
echo "Starting script..."

# {/fact}
