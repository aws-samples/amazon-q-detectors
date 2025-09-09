// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-s3transfermanagershutdown@v1.0 defects=0}
import com.amazonaws.services.s3.model.*;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.amazonaws.services.s3.transfer.Upload;

public class S3TransferManagershutdownCompliant {

    // Compliant: `TransferManager` is shutdown in the `finally` block.
    public void compliant(final PutObjectRequest putRequest) {
        TransferManager transferManager = TransferManagerBuilder.defaultTransferManager();
        try {
            final Upload upload = transferManager.upload(putRequest);
            upload.waitForCompletion();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            transferManager.shutdownNow();
        }
    }

}
// {/fact}
