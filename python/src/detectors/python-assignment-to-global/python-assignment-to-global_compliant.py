# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-assignment-to-global@v1.0 defects=0}
import globalSetting

WIDTH = 0
HEIGHT = 0

def compliant(w, h):
    # Compliant: Using a configuration module to mutate global state.
    globalSetting.WIDTH = w
    globalSetting.HEIGHT = h
    return globalSetting.WIDTH * globalSetting.HEIGHT
# {/fact}
