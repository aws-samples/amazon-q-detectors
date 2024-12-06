#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-avoid-complex-comprehension@v1.0 defects=1}
def avoid_complex_comprehension_non_compliant():
    text = [['bar', 'pie', 'line'], ['Rome', 'Madrid', 'Houston'], ['aa', 'bb', 'cc', 'dd']]
    # Noncompliant: list comprehensions with more than two control sub expressions are hard to read and maintain.
    text_2 = [y.upper() for x in text if len(x) == 3 for y in x if y.startswith('f')]
    return text_2
# {/fact}
