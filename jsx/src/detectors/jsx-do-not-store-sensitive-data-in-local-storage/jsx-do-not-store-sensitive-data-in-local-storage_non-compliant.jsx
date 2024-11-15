// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-do-not-store-sensitive-data-in-local-storage@v1.0 defects=1}
const jwt_decode = require("jwt-decode")

export const noncompliant = async () => {
    const { token } = await retrieveToken()
    // Noncompliant: Sensitive data is stored in `localStorage`.
    localStorage.setItem("TOKEN", token)
}
// {/fact}
