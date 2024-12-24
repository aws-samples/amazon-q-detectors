// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-new-function-detected@v1.0 defects=1}
function nonCompliant()
{
    let dynamicOperationStr = window.prompt();
    // Noncompliant: Avoid using the `new Function` constructor, especially with external user input, as it poses security risks.
    let dynamicOperation = new Function(dynamicOperationStr);
    console.log("Here is the output of your log function: " + dynamicOperation(1, 2))
}
// {/fact}
