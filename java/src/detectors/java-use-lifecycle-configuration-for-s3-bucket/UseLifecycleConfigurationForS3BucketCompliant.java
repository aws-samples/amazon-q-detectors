// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-use-lifecycle-configuration-for-s3-bucket@v1.0 defects=0}
import software.amazon.awscdk.Duration;
import software.amazon.awscdk.NestedStack;
import software.amazon.awscdk.NestedStackProps;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.s3.Bucket;
import software.amazon.awscdk.services.s3.BucketEncryption;
import software.amazon.awscdk.services.s3.BucketProps;
import software.amazon.awscdk.services.s3.LifecycleRule;
import software.constructs.Construct;

public class UseLifecycleConfigurationForS3BucketCompliant extends NestedStack {

    public static final String NESTED_STACK_NAME = "SharedExecResource";
    private static final String USER_DATA_S3_BUCKET = "user-data";

    public UseLifecycleConfigurationForS3BucketCompliant(final Construct parent,
                                           final StackProps stackProps) {
        super(parent, NESTED_STACK_NAME, NestedStackProps.builder().build());
    }

    // Compliant: Creates an S3 bucket with a lifecycle rule configured, helping to manage storage costs and data retention.
    private Bucket compliant() {
        String bucketName = "sampleBucket";
        Bucket bucket = new Bucket(this, bucketName, BucketProps.builder()
                .bucketName(bucketName.toLowerCase())
                .encryption(BucketEncryption.S3_MANAGED)
                .build());

        bucket.addLifecycleRule(LifecycleRule.builder()
                .expiration(Duration.days(365))
                .build());
        return bucket;
    }
}
// {/fact}
