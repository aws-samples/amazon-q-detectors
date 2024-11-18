// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-clear-text-protocol@v1.0 defects=1}
import org.apache.commons.net.ftp.FTPClient;

class ClearTextProtocolNoncompliant {
    // Noncompliant: `FTPClient` uses clear text protocol, which is insecure for transmitting sensitive data.
    void nonCompliant() {
        FTPClient ftp = new FTPClient();
    }

}
// {/fact}
