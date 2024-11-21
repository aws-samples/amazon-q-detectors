// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-do-not-log-confidential-information@v1.0 defects=1}
var { Signale } = require('signale')

function noncompliant() {
    var options = {
        disabled: false,
        interactive: false,
        logLevel: 'info',
        scope: 'custom',
        // Noncompliant: Empty list is assigned to `secrets`.
        secrets: []
    }

    const logger = new Signale(options)
    logger.log('Secret is: ', info)
}
// {/fact}
