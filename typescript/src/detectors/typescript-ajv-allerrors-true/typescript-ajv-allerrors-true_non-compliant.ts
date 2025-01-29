// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-ajv-allerrors-true@v1.0 defects=1}
import Ajv from 'ajv';

function nonCompliant(): Ajv {
    // Noncompliant: `allErrors` is explicitly set to `true`.
    const settings = { allErrors: true, smth: 'else' };
    const ajv1 = new Ajv(settings);
    return ajv1;
}
// {/fact}
