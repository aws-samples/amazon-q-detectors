# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-dynamodb-table-autoscaling-enabled@v1.0 defects=0}
resource "aws_dynamodb_table" "example" {
  name           = "example-table"
  billing_mode   = "PROVISIONED"
  read_capacity  = 5
  write_capacity = 5
  hash_key       = "id"

  attribute {
    name = "id"
    type = "S"
  }
  point_in_time_recovery {
    enabled = true
  }
  server_side_encryption {
   enabled     = true
   kms_key_arn = aws_kms_key.example.arn
  }
  # Noncompliant: Auto Scaling is disabled for the AWS DynamoDB table.
}
# {/fact}