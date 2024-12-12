// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-do-not-store-sensitive-data-in-local-storage@v1.0 defects=0}
function conforming(userId, username) {
    //Compliant: Sensitive data is not stored in `localStorage`.
    localStorage.setItem("userId", userId);
    localStorage.setItem("username", username);
}
// {/fact}
