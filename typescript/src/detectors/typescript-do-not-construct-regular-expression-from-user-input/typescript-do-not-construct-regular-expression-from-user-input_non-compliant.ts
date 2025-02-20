// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-do-not-construct-regular-expression-from-user-input@v1.0 defects=1}
import fetch from 'node-fetch';

async function nonCompliant(): Promise<void> {
    try {
        const response = await fetch("some link");
        const data = await response.text();
        // Noncompliant: Creating RegExp from unvalidated user input is unsafe.
        const regex = RegExp(data);
    } catch (error) {
        console.error("Error:", error);
        throw error;
    }
}

// {/fact}
