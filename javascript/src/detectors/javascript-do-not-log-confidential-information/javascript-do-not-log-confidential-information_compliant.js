// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-do-not-log-confidential-information@v1.0 defects=0}
var { Signale } = require('signale')

function loggingOfSensitiveInformationCompliant() {
    var options = {
        disabled: false,
        interactive: false,
        logLevel: 'info',
        scope: 'custom',
        // Compliant: Patterns for sensitive data like `secrets` are configured to prevent logging confidential information.
        secrets: ["apiKey", "password", "token", "[1-9]{10}", "\\w{8,}"]
    }

    const logger = new Signale(options)
    logger.log('Secret is: ', info)
}

// {/fact}
