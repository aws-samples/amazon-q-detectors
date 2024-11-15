// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-do-not-store-sensitive-data-in-local-storage@v1.0 defects=0}
function compliant() {
    // Compliant: Store tokens securely using an HTTP-only cookie.
    document.cookie = "token=; Secure; HttpOnly; SameSite=Strict"
}
// {/fact}