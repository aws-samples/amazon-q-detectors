// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-do-not-use-raw-html-in-join@v1.0 defects=0}
function compliant(data1: string, data2: string): void {
    // Compliant: Raw HTML is not used in `join()`.
    const x = [data1, data2].join();
}
// {/fact}
