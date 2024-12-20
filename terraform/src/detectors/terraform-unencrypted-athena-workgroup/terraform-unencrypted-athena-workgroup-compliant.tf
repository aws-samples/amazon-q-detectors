# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-unencrypted-athena-workgroup@v1.0 defects=0}
resource "aws_athena_workgroup" "test" {
  configuration {
   result_configuration {
     output_location = "s3://mys3bucket"
     # Compliant: The Athena Workgroup is encrypted.
     encryption_configuration {
       encryption_option = "SSE_KMS"
       kms_key_arn       = "mykmsarn"
    }
  }
}
  name = ""
}
# {/fact}
