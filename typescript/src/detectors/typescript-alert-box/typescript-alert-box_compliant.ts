// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-alert-box@v1.0 defects=0}
function showWarningCompliant() {
    // Compliant: Logging the message to the console instead of using a pop-up.
    console.warn("Warning: This action is irreversible!");
}
// {/fact}
