// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-do-not-store-sensitive-data-in-local-storage@v1.0 defects=1}

function nonCompliant(username, password) {
    localStorage.setItem("USERNAME", username);
    //Noncompliant: Sensitive data being stored in `localStorage`.
    localStorage.setItem("PASSWORD", password);     
}
// {/fact}
