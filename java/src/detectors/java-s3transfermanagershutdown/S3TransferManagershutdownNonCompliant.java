// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-s3transfermanagershutdown@v1.0 defects=1}
import com.amazonaws.services.s3.model.*;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.amazonaws.services.s3.transfer.Upload;

public class S3TransferManagershutdownNonCompliant {

    // Noncompliant: `TransferManager` is not shutdown.
    public void nonCompliant(final PutObjectRequest putRequest) {
        try {
            TransferManager transferManager = TransferManagerBuilder.defaultTransferManager();
            final Upload upload = transferManager.upload(putRequest);
            upload.waitForCompletion();
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
// {/fact}
