# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-restrict-log4j2-msg-lookup@v1.0 defects=1}
resource "aws_wafv2_web_acl" "default" {
  name  = "x-always-block_web_acl"
  scope = "REGIONAL"

  default_action {
    allow {}
  }

  rule {
    name     = "x-always-block_web_acl_rule"
    priority = 1

    override_action {
      none {}
    }
    # Noncompliant: `visibility_config` is not defined.
    statement {
      rule_group_reference_statement {
        arn = aws_wafv2_rule_group.x_always_block.arn
      }
    }
    visibility_config {
      cloudwatch_metrics_enabled = false
      metric_name                = "friendly-rule-metric-name"
      sampled_requests_enabled   = false
    }
  }

  visibility_config {
    cloudwatch_metrics_enabled = false
    metric_name                = ""
    sampled_requests_enabled   = false
  }
}
resource "aws_wafv2_web_acl_logging_configuration" "example" {
  log_destination_configs = [aws_kinesis_firehose_delivery_stream.example.arn]
  resource_arn            = aws_wafv2_web_acl.default.arn
  redacted_fields {
    single_header {
      name = "user-agent"
    }
  }
}
# {/fact}