// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-use-lifecycle-configuration-for-s3-bucket@v1.0 defects=1}
import software.amazon.awscdk.NestedStack;
import software.amazon.awscdk.NestedStackProps;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.s3.Bucket;
import software.amazon.awscdk.services.s3.BucketEncryption;
import software.amazon.awscdk.services.s3.BucketProps;
import software.constructs.Construct;

public class UseLifecycleConfigurationForS3BucketNoncompliant extends NestedStack {

    public UseLifecycleConfigurationForS3BucketNoncompliant(final Construct parent,
                                                         final StackProps stackProps) {
        super(parent, "NESTED_STACK_NAME", NestedStackProps.builder().build());

    }

    // Noncompliant: Creates an S3 bucket without configuring lifecycle rules, potentially leading to unnecessary storage costs.
    private Bucket nonCompliant() {
        final String bucketName = "bucketSample";
        final Bucket bucket = new Bucket(this, bucketName, BucketProps.builder()
                .bucketName(bucketName.toLowerCase())
                .encryption(BucketEncryption.S3_MANAGED)
                .build());
        return bucket;
    }
}
// {/fact}
