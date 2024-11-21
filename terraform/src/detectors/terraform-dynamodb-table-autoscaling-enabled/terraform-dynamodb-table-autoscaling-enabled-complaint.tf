# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-dynamodb-table-autoscaling-enabled@v1.0 defects=0}
resource "aws_dynamodb_table" "my_table" {
  name           = "my-table"
  billing_mode   = "PAY_PER_REQUEST"
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
  # Compliant: Auto Scaling is enabled for the AWS DynamoDB table.
  auto_scaling_settings_primary {
    max_capacity  = 10
    min_capacity  = 5
    scale_in_cooldown  = 60
    scale_out_cooldown = 60
    target_value = 70
  }
}
# {/fact}