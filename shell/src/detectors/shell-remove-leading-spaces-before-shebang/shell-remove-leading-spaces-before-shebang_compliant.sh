# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-remove-leading-spaces-before-shebang@v1.0 defects=0}
	 
# Compliant: Shebang starts at the very first character of the file.
#!/bin/bash
echo "Hello Shell"

# {/fact}
