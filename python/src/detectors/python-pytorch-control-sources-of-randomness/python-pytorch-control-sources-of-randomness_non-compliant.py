# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-pytorch-control-sources-of-randomness@v1.0 defects=1}
# Noncompliant: Using `pytorch` library without a fixed seed for random numbers can cause multiple executions of application to behave differently.
import torch

tensor_noncompliant = torch.randint(3, 10, (2, 2))
print(tensor_noncompliant)
# {/fact}
