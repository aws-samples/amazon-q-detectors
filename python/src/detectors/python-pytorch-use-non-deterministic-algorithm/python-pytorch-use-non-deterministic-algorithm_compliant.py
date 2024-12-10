# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-pytorch-use-non-deterministic-algorithm@v1.0 defects=0}
import torch.nn as nn
import torch

torch.manual_seed(42)

def compliant(in_planes):
    # Compliant: The deterministic algorithms are used to ensure reproducibility by calling `torch.use_deterministic_algorithms(True)`.
    torch.use_deterministic_algorithms(True)
    return nn.Conv2d(in_planes, 2, kernel_size=3, stride=1, padding=1, bias=True)
# {/fact}
