# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-pytorch-miss-call-to-zero-grad@v1.0 defects=1}
def train_epoch(model, dataloader, criterion, optimizer, i_epoch):
    model.train()
    for (data, offset, label) in enumerate(dataloader):
        output = model(data, offset)
        loss = criterion(output, label)
        # Noncompliant: Training a neural network model without calling `zero_grad()` causes gradients to be accumulated.
        loss.backward()
# {/fact}
