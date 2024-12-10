# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-pytorch-miss-call-to-eval@v1.0 defects=0}
from pytorch_pfn_extras import training
from pytorch_pfn_extras.training import triggers
import torch

torch.manual_seed(42)

def _test_trigger(trainer, trigger, expected, finished):
    for (e, f) in zip(expected, finished):
        with trainer.run_iteration():
            pass
        assert trigger(trainer) == e
        assert trigger.finished == f

def test_resumed_trigger(
        iters_per_epoch, schedule, expected, finished, resume):
    trainer = training.ExtensionsManager(
        {}, [], 100, iters_per_epoch=iters_per_epoch)
    trigger = triggers.ManualScheduleTrigger(*schedule)

    _test_trigger(
        trainer, trigger,
        expected[:resume], finished[:resume])

    state = trigger.state_dict()
    new_trigger = triggers.ManualScheduleTrigger(*schedule)
    new_trigger.load_state_dict(state)
    with torch.inference_mode():
        # Compliant: Enabled the evaluation mode.
        new_trigger.eval()

    _test_trigger(trainer, new_trigger, expected[resume:], finished[resume:])
# {/fact}
