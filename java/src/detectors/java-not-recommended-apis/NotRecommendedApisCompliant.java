// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-not-recommended-apis@v1.0 defects=0}
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.amazonaws.services.s3.transfer.Upload;

public class NotRecommendedApisCompliant {

    // Compliant: Uses recommended APIs from `TransferManager`.
    public void shutdownTransferManagerCompliant(final PutObjectRequest putRequest) {
        TransferManager transferManager = null;
        try {
            transferManager = TransferManagerBuilder.defaultTransferManager();
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
