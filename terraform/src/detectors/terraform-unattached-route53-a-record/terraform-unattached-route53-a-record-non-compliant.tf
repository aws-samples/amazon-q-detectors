# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-unattached-route53-a-record@v1.0 defects=1}
resource "aws_route53_record" "route53" {
  zone_id = data.aws_route53_zone.primary.zone_id
  name    = "dns.freebeer.site"
  type    = "A"
  ttl     = "300"
  # Noncompliant: The Route 53 A record does not have an attached resource.
}
# {/fact}
