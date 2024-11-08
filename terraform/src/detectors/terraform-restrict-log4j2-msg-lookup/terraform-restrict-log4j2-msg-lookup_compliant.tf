# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-restrict-log4j2-msg-lookup@v1.0 defects=0}
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
    statement {
      managed_rule_group_statement {
        name        = "AWSManagedRulesKnownBadInputsRuleSet"
        vendor_name = "AWS"
      }
    }
    # Compliant: WAF prevents message lookup in Log4j2.
    visibility_config {
      cloudwatch_metrics_enabled = false
      metric_name                = ""
      sampled_requests_enabled   = false
    }
  }
  visibility_config {
    cloudwatch_metrics_enabled = false
    metric_name                = ""
    sampled_requests_enabled   = false
  }
  visibility_config {
    cloudwatch_metrics_enabled = false
    metric_name                = "friendly-rule-metric-name"
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