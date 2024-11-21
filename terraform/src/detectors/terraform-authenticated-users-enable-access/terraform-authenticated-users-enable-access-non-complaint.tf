# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-authenticated-users-enable-access@v1.0 defects=1}
resource "aws_s3_bucket_acl" "bucket" {
  bucket = "name"
  access_control_policy {
    grant {
      grantee {
        id   = "52b113e7a2f25102679df27bb0ae12b3f85be6"
        type = "CanonicalUser"
      }
      permission = "READ"
    }
    grant {
      grantee {
        type = "Group"
        # Noncompliant: Amazon S3 buckets are accessible to any authenticated user.
        uri  = "http://acs.amazonaws.com/groups/global/AuthenticatedUsers"
      }
      permission = "READ_ACP"
    }
    owner {
      id = data.aws_canonical_user_id.current.id
    }
  }
}
# {/fact}