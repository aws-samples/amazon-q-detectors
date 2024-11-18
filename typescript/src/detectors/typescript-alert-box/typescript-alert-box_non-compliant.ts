// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-alert-box@v1.0 defects=1}
function showWarningNoncompliant() {
    // Noncompliant: Using `alert` to show a warning pop-up, which should be avoided in production.
    alert("Warning: This action is irreversible!");
}
// {/fact}
