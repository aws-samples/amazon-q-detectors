// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-new-function-detected@v1.0 defects=0}
function compliant() {

    let operationsMap = {
        "add" : (a, b) => a + b,
        "subtract" : (a, b) => a - b,
        "multiply" : (a, b) => a * b,
        "divide" : (a, b) => a / b
    }

    let operationKey = window.prompt();

    // Compliant: Using a map to dynamically select and execute operations.
    let operation = operationsMap[operationKey];

    if (operation)
    {
        console.log("Here is the output of your log function: " + operation(1, 2));
    }
    else
    {
        console.log("Operation not found!");
    }
}
// {/fact}
