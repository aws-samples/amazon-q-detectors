#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-notebook-invalid-execution-order@v1.0 defects=1}
def cellEdge(x):
	pass
cellEdge(0)
def foo(p1, p2):
    return p1 + p2, p1 * p2, p1 ** p2
cellEdge(2)
# Noncompliant: The code attempts to use variables `x` and `y` in the function call before they are defined, which would raise a `NameError`.
a, b, c = foo(x, y)
cellEdge(1)
x = 3
y = 7
cellEdge(3)
print (a, b, c)
# {/fact}
