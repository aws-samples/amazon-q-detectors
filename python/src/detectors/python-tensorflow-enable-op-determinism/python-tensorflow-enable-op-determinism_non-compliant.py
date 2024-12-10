#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-tensorflow-enable-op-determinism@v1.0 defects=1}
import tensorflow as tf

# Noncompliant: Random seed is not set and `enable_op_determinism()` is not used, which can lead to non-deterministic behavior and inconsistent outputs.
data = tf.ones((1, 1))
layer = tf.keras.layers.Input(shape=[1])
model = tf.keras.models.Model(inputs=layer, outputs=layer)
model.compile(loss="categorical_crossentropy", metrics="AUC")
model.fit(x=data, y=data)
# {/fact}
