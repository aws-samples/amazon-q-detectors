#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-pytorch-avoid-softmax-with-nllloss@v1.0 defects=1}
import torch
import torch.nn as nn

torch.manual_seed(42)

def non_compliant():
    # Noncompliant: Uses `softmax` with `NLLLoss` which is incorrect because `NLLLoss` expects log probabilities as input, not raw probabilities from `softmax`.
    m = nn.functional.softmax(dim=1)
    loss = nn.NLLLoss()
    input = torch.randn(3, 5, requires_grad=True)
    target = torch.tensor([1, 0, 4])
    output = loss(m(input), target)
# {/fact}
