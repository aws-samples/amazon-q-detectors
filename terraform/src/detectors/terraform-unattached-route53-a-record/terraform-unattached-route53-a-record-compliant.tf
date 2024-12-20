# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-unattached-route53-a-record@v1.0 defects=0}
resource "aws_eip" "route53" {
  instance = aws_instance.example.id
  vpc      = true
}

resource "aws_route53_record" "pass" {
  zone_id = data.aws_route53_zone.primary.zone_id
  name    = "dns.freebeer.site"
  type    = "A"
  ttl     = "300"
  # Compliant: The Route 53 A record has an attached resource.
  records = [aws_eip.route53.public_ip]
}
# {/fact}
