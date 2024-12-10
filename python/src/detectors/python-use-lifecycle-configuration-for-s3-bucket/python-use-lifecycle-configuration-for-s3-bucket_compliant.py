#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-use-lifecycle-configuration-for-s3-bucket@v1.0 defects=0}
import aws_cdk as cdk
import aws_cdk.aws_s3 as s3

class S3BucketZonesStack(cdk.Stack):
    def create_data_lake_zone_bucket(
            self, logical_id, bucket_name, access_logs_bucket, s3_kms_key
        ) -> s3.Bucket:
        lifecycle_rules = [
                    s3.LifecycleRule(
                        enabled=True,
                        expiration=cdk.Duration.days(60),
                        noncurrent_version_expiration=cdk.Duration.days(30)
                    )
                ]
        bucket = s3.Bucket(
                    self,
                    id=logical_id,
                    access_control=s3.BucketAccessControl.PRIVATE,
                    block_public_access=s3.BlockPublicAccess.BLOCK_ALL,
                    bucket_key_enabled=True,
                    bucket_name=bucket_name,
                    encryption=s3.BucketEncryption.KMS,
                    encryption_key=s3_kms_key,
                    # Compliant: Lifecycle rules have been configured.
                    lifecycle_rules=lifecycle_rules,
                    public_read_access=False,
                    removal_policy=self.removal_policy,
                    versioned=True,
                    object_ownership=s3.ObjectOwnership.OBJECT_WRITER,
                    server_access_logs_bucket=access_logs_bucket,
                    server_access_logs_prefix=bucket_name,
                    enforce_ssl=True
                )
# {/fact}
