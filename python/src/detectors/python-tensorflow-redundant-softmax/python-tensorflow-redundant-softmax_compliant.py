#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-tensorflow-redundant-softmax@v1.0 defects=0}
import tensorflow as tf

tf.keras.utils.set_random_seed(1)
tf.config.experimental.enable_op_determinism()

def compliant():
    logits = [[4.0, 2.0, 1.0], [0.0, 5.0, 1.0]]
    labels = [[1.0, 0.0, 0.0], [0.0, 0.8, 0.2]]
    # Compliant: Correctly passes raw logits directly to `softmax_cross_entropy_with_logits`, allowing the function to handle the softmax operation internally.
    tf.nn.softmax_cross_entropy_with_logits(labels=labels, logits=logits)
# {/fact}
