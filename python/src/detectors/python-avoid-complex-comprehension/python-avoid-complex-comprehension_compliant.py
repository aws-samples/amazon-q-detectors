#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-avoid-complex-comprehension@v1.0 defects=0}
def avoid_complex_comprehension_compliant():
    text = [['bar', 'pie', 'line'], ['Rome', 'Madrid', 'Houston'], ['aa', 'bb', 'cc', 'dd']]
    text_1 = []
    # Compliant: Easy to read and maintain.
    for x in text:
        if len(x) > 3:
            for y in x:
                text_1.append(y)
# {/fact}
