// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-origins-verified-cross-origin-communication@v1.0 defects=1}
function originsVerifiedCrossOriginCommunicationsNoncompliant() {
    var iframe = (document?.querySelector('.testiframe') as HTMLIFrameElement);
    // Noncompliant: The wildcard keyword `*` is used.
    iframe?.contentWindow?.postMessage("secret_value", "*");
}
// {/fact}
