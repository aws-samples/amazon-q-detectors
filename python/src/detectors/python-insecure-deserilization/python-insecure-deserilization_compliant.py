#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-insecure-deserilization@v1.0 defects=0}
import yaml

def compliant():
    var = input()
    # Compliant: `yaml.safe_load_all` is being used.
    yaml.safe_load_all(var)
# {/fact}
