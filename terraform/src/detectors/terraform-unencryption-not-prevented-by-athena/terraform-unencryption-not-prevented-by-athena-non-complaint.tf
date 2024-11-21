# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-unencryption-not-prevented-by-athena@v1.0 defects=1}
resource "aws_athena_workgroup" "example" {
  name = "example-workgroup"

  configuration {
    # Noncompliant: The Athena workgroup does not prevent unencryption.
    enforce_workgroup_configuration    = false
    result_configuration {
      output_location = "s3://example-bucket/athena-results"

      encryption_configuration {
        encryption_option = "SSE_S3"
      }
    }
  }
}
# {/fact}