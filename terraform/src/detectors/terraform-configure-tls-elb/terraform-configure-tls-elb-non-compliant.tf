# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-configure-tls-elb@v1.0 defects=1}
resource "aws_lb_listener" "front_end" {
  load_balancer_arn = aws_lb.front_end.arn
  port              = "443"
  protocol          = "HTTPS"
  # Noncompliant: The AWS Load Balancer is not configured to use TLS 1.2.
  certificate_arn   = "arn:aws:acm:eu-west-2:999999999:certificate/77777777-5d4a-457f-8888-02550c8c9244"

  default_action {
    type             = "forward"
    target_group_arn = aws_lb_target_group.front_end.arn
  }
}
# {/fact}
