// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-origins-verified-cross-origin-communication@v1.0 defects=0}
function originsVerifiedCrossOriginCommunicationsCompliant() {
    var iframe = (document?.querySelector('.testiframe') as HTMLIFrameElement);
    // Compliant: Using secure origin.
    iframe?.contentWindow?.postMessage("secret_value", "https://secure.example.com");
}

// {/fact}
