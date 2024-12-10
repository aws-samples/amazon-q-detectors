#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-pytorch-sigmoid-before-bceloss@v1.0 defects=0}
import torch
import torch.nn as nn

def compliant():
    torch.manual_seed(42)
    
    # Compliant: Uses `BCEWithLogitsLoss` which combines sigmoid and binary cross-entropy into a single numerically stable operation.
    loss = nn.BCEWithLogitsLoss()

    input = torch.randn(3, requires_grad=True)
    target = torch.empty(3).random_(2)

    output = loss(input, target)
    output.backward()
# {/fact}
