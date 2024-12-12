# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-nonhttps-load-balancer@v1.0 defects=0}
resource "aws_lb_listener" "https_listener" {
  load_balancer_arn = "<load-balancer-arn>"
  port              = 443
  # Compliant: The AWS Elastic Load Balancer v2 (ELBv2) listener allows connection requests over HTTPS.
  protocol          = "HTTPS"
  ssl_policy        = "ELBSecurityPolicy-TLS13-1-2-2021-06"

  default_action {
    type             = "forward"
    target_group_arn = "<target-group-arn>"
  }
}
# {/fact}
