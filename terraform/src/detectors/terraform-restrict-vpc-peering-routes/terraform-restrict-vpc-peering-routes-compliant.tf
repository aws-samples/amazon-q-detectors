# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-restrict-vpc-peering-routes@v1.0 defects=0}
resource "aws_route" "aws_route_pass_1" {
  route_table_id            = "rtb-4fbb3ac4"
  # Compliant: The AWS route table with VPC peering restricts traffic to specific sources and destinations.
  destination_cidr_block    = "10.0.1.0/22"
  vpc_peering_connection_id = "pcx-45ff3dc1"
}
# {/fact}
