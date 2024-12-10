# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-pytorch-disable-gradient-calculation-during-evaluation@v1.0 defects=0}
import torch
import random
import numpy as np

torch.manual_seed(42)
random.seed(42)
np.random.seed(42)

def compliant(self, input: Tensor) -> bool:
    dim = [0]
    dim.extend(range(2, input.dim()))

    # Compliant: Using `torch.inference_mode()` will reduce memory consumption for computations.
    with torch.inference_mode():
        self.sum += input.sum(dim)
        self.sum_squares += (input ** 2).sum(dim)

    size = input.size().numel() // input.size(1)
    self.counter += size
    self.tracked += 1

    return self.tracked == self.chunks
# {/fact}
