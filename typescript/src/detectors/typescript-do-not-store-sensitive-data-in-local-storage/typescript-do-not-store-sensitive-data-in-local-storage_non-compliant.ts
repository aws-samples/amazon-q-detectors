// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-do-not-store-sensitive-data-in-local-storage@v1.0 defects=1}
function nonCompliant(username: string, password: string): void {
    localStorage.setItem("USERNAME", username);
    // Noncompliant: Sensitive data being stored in `localStorage`.
    localStorage.setItem("PASSWORD", password);     
}
// {/fact}
