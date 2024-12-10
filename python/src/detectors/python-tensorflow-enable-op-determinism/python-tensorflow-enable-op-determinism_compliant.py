#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-tensorflow-enable-op-determinism@v1.0 defects=0}
import tensorflow as tf

# Compliant: Both random seed is set with `set_random_seed(1)` and `enable_op_determinism()` is properly used, ensuring reproducible results.
tf.keras.utils.set_random_seed(1)
tf.config.experimental.enable_op_determinism()
data = tf.ones((1, 1))
layer = tf.keras.layers.Input(shape=[1])
model = tf.keras.models.Model(inputs=layer, outputs=layer)
model.compile(loss="categorical_crossentropy", metrics="AUC")
model.fit(x=data, y=data)
# {/fact}
