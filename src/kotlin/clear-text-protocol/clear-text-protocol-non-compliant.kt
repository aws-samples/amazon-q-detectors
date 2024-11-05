// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-clear-text-protocol@v1.0 defects=1}
import org.apache.commons.net.ftp.FTPClient

// Noncompliant: Using clear-text protocols such as `ftp` which is insecure.
fun clear_text_protocol_noncompliant() {
    val ftpClient = FTPClient()
}
// {/fact}
