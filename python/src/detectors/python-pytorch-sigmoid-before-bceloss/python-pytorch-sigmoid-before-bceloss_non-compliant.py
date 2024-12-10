#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-pytorch-sigmoid-before-bceloss@v1.0 defects=1}
import torch
import torch.nn as nn

def non_compliant():
    torch.manual_seed(42)
    
    # Noncompliant: Uses `BCELoss` directly without sigmoid integration, which can lead to numerical instability in the computation.
    loss = nn.BCELoss()

    input = torch.randn(3, requires_grad=True)
    target = torch.empty(3).random_(2)

    output = loss(input, target)
    output.backward()
# {/fact}
