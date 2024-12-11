#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-tensorflow-redundant-softmax@v1.0 defects=1}
import tensorflow as tf

tf.keras.utils.set_random_seed(1)
tf.config.experimental.enable_op_determinism()

def non_compliant():
    logits = [[4.0, 2.0, 1.0], [0.0, 5.0, 1.0]]
    labels = [[1.0, 0.0, 0.0], [0.0, 0.8, 0.2]]
    # Noncompliant: Incorrectly applies `tf.nn.softmax()` to logits before passing to `softmax_cross_entropy_with_logits`, causing redundant softmax computation and potential numerical instability.
    tf.nn.softmax_cross_entropy_with_logits(labels=labels, logits=tf.nn.softmax(logits))
# {/fact}
