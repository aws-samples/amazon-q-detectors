#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-insecure-deserilization@v1.0 defects=1}
import yaml

def non_compliant():
    var = input()
    # Noncompliant: Untrusted user input is passed in `yaml.load_all`.
    yaml.load_all(var)
# {/fact}
