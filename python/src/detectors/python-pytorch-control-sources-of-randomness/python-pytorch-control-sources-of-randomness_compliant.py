# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-pytorch-control-sources-of-randomness@v1.0 defects=0}
import torch

# Compliant: Using `pytorch` library with a fixed seed for random numbers can ensure reproducibility in multiple executions.
torch.manual_seed(42)
tensor_compliant = torch.randint(3, 10, (2, 2))
print(tensor_compliant)
# {/fact}
