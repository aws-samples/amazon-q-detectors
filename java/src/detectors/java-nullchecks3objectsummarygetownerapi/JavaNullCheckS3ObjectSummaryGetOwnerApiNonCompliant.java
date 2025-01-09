// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-nullchecks3objectsummarygetownerapi@v1.0 defects=1}
import com.amazonaws.services.s3.model.S3ObjectSummary;
import java.io.IOException;

public class JavaNullCheckS3ObjectSummaryGetOwnerApiNonCompliant {

    public static void getOwnerMissingNullCheck(final S3ObjectSummary objectSummary) throws IOException {
        String owner = null;
        // Noncompliant: `null` check is not performed on the owner
        owner = objectSummary.getOwner().getDisplayName();
        System.out.println(owner);
    }
}
// {/fact}
