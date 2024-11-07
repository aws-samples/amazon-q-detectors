# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-remove-leading-spaces-before-shebang@v1.0 defects=1}
	 
# Noncompliant: Leading spaces before the shebang.
  #!/bin/bash
echo "Hello Shell"

# {/fact}
