# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-data-loader-with-multiple-workers@v1.0 defects=0}
import torch
from torch.utils.data import DataLoader
import random
import numpy as np

torch.manual_seed(42)
random.seed(42)
np.random.seed(42)

class MyDataset(Dataset):
    def __init__(self):
        self.data = torch.randn(10, 3, 24, 24)
        self.target = torch.randint(0, 10, (10,))

    def __getitem__(self, index):
        x = self.data[index]
        y = self.target[index]

        return {'data': x, 'target': y}

    def __len__(self):
        return len(self.data)

dataset = MyDataset()

# Compliant: The value of `num_workers` is `0`, which helps to prevent memory leak while initialising the DataLoader.
loader = DataLoader(dataset, batch_size=2, num_workers=0)

for batch in loader:
    data = batch['data']
    target = batch['target']
    print(data.shape)
# {/fact}
