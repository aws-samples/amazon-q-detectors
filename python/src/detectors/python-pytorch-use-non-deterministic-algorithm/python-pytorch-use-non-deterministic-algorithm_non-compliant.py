# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-pytorch-use-non-deterministic-algorithm@v1.0 defects=1}
import torch.nn as nn
import torch

torch.manual_seed(42)

# Noncompliant: Using APIs with nondeterministic operations by default can cause inconsistent or unpredictable results.
def non_compliant(in_planes):
    return nn.Conv2d(in_planes, 2, kernel_size=3, stride=1, padding=1, bias=True)
# {/fact}
