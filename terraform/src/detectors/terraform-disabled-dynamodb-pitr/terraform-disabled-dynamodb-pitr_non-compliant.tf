# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-disabled-dynamodb-pitr@v1.0 defects=1}
resource "aws_dynamodb_table" "basic-dynamodb-table" {
  name           = "GameScores"
  # Noncompliant: `point_in_time_recovery` is disabled.
  attribute {
    name = "UserId"
    type = "S"
  }
  ttl {
    attribute_name = "TimeToExist"
    enabled        = false
  }
  tags = {
    Name        = "dynamodb-table-1"
    Environment = "production"
  }
  enabled = true
  server_side_encryption {
    enabled = true
    kms_key_arn = "arn:aws:kms:us-west-2:123456789012:key/1234abcd-12ab-34cd-56ef-1234567890ab"
  }
}
resource "aws_appautoscaling_target" "pass" {
  resource_id        = "table/${aws_dynamodb_table.basic-dynamodb-table.name}"
  scalable_dimension = "dynamodb:table:ReadCapacityUnits"
  service_namespace  = "dynamodb"
  min_capacity       = 1
  max_capacity       = 15
}

resource "aws_appautoscaling_policy" "pass" {
  name               = "rcu-auto-scaling"
  service_namespace  = aws_appautoscaling_target.pass.service_namespace
  scalable_dimension = aws_appautoscaling_target.pass.scalable_dimension
  resource_id        = aws_appautoscaling_target.pass.resource_id
  policy_type        = "TargetTrackingScaling"

  target_tracking_scaling_policy_configuration {
    predefined_metric_specification {
      predefined_metric_type = "DynamoDBReadCapacityUtilization"
    }

    target_value       = 75
    scale_in_cooldown  = 300
    scale_out_cooldown = 300
  }
}
# {/fact}