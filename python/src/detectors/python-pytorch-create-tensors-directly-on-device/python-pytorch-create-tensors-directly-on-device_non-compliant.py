# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-pytorch-create-tensors-directly-on-device@v1.0 defects=1}
import torch
import numpy as np
import random

torch.manual_seed(42)
np.random.seed(42)
random.seed(42)

def non_compliant():
    # Noncompliant: Creating the `tensor` on the CPU and then moving it to the device may impact the performance.
    t1 = torch.tensor([1, 2, 3, 4])
    t1.to(device='cuda')
# {/fact}
