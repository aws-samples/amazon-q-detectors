// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-clear-text-protocol@v1.0 defects=0}
import org.apache.commons.net.ftp.FTPSClient;

class ClearTextProtocolCompliant {
    // Compliant: `FTPSClient` uses a secure protocol (FTPS) instead of clear text FTP.
    void compliant() {
        new FTPSClient();
    }

}
// {/fact}
