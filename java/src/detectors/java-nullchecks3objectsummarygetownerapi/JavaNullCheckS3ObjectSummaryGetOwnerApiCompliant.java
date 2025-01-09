// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-nullchecks3objectsummarygetownerapi@v1.0 defects=0}
import com.amazonaws.services.s3.model.S3ObjectSummary;
import java.io.IOException;

public class JavaNullCheckS3ObjectSummaryGetOwnerApiCompliant {

    public static void getOwnerNullCheck(final S3ObjectSummary objectSummary) throws IOException {
        String owner = null;
        // Compliant: `null`check is performed on the owner.
        if (objectSummary.getOwner() != null) {
            owner = objectSummary.getOwner().getDisplayName();
        }
        System.out.println(owner);
    }
}
// {/fact}
