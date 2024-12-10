#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-notebook-invalid-execution-order@v1.0 defects=0}
def cellEdge(x):
	pass
cellEdge(0)
def foo(p1, p2):
    return p1 + p2, p1 * p2, p1 ** p2
cellEdge(1)
x = 3
y = 4
cellEdge(2)
# Compliant: Properly defines the variables before using them in the function call, following the correct execution order.
a, b, c = foo(x, y)
cellEdge(3)
print (a, b, c)
# {/fact}
