#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-pytorch-avoid-softmax-with-nllloss@v1.0 defects=0}
import torch
import torch.nn as nn

torch.manual_seed(42)

def compliant():
    # Compliant: Uses `LogSoftmax` with `NLLLoss` which correctly handles log probabilities as required by `NLLLoss` for numerical stability.
    m = nn.LogSoftmax(dim=1)
    loss = nn.NLLLoss()
    input = torch.randn(3, 5, requires_grad=True)
    target = torch.tensor([1, 0, 4])
    output = loss(m(input), target)
# {/fact}
