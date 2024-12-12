# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-unencrypted-athena-workgroup@v1.0 defects=1}
resource "aws_athena_workgroup" "test" {
  configuration {
   result_configuration {
     output_location = "s3://mys3bucket"
     # Noncompliant: The Athena Workgroup is not encrypted.
  }
}
  name = ""
}
# {/fact}
