# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-detect-absolute-paths@v1.0 defects=0}
import pandas as pd

def __CELL_EDGE__(x):
    pass
__CELL_EDGE__(0)
# Compliant: Using relative path helps to prevent issues in your computational environment.
data = pd.read_csv("WorldCupMatches.csv")
# {/fact}
