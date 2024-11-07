// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-clear-text-protocol@v1.0 defects=0}
import org.apache.commons.net.ftp.FTPSClient

// Compliant: Using clear-text protocols such as `ftps` which is secure.
fun clear_text_protocol_compliant() {
    val ftpsClient = FTPSClient(true);
}
// {/fact}
