# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-disabled-alb-drops-http-headers@v1.0 defects=0}
resource "aws_wafv2_web_acl_association" "example" {
  resource_arn = aws_lb.example.arn
  web_acl_arn  = aws_wafv2_web_acl.example.arn
}

resource "aws_wafv2_web_acl_logging_configuration" "example" {
  log_destination_configs = [aws_cloudwatch_log_group.waf_log_group.arn]
  resource_arn           = aws_wafv2_web_acl.example.arn
}

resource "aws_lb" "example" {
  name                       = "example-alb"
  # Compliant: The ALB(Application Load Balancer) drops HTTP headers.
  drop_invalid_header_fields = true
  enable_deletion_protection = true

  access_logs {
    bucket  = aws_s3_bucket.lb_logs.bucket
    prefix  = "test-lb"
    enabled = true
  }
}
# {/fact}