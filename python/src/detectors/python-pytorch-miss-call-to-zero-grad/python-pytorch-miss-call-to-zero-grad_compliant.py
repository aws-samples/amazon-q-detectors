# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-pytorch-miss-call-to-zero-grad@v1.0 defects=0}
def train_epoch(model, dataloader, criterion, optimizer, i_epoch):
    model.train()
    for (data, offset, label) in enumerate(dataloader):
        # Compliant: The `zero_grad()` method zeros out gradients between minibatches to prevent gradient interference.
        optimizer.zero_grad()
        output = model(data, offset)
        loss = criterion(output, label)
        loss.backward()
# {/fact}
