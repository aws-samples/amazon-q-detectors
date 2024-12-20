# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-restrict-vpc-peering-routes@v1.0 defects=1}
resource "aws_route_table" "example" {
  vpc_id = aws_vpc.example.id
  # Noncompliant: The AWS route table with VPC peering is overly permissive, allowing all traffic.
  route {
    cidr_block                = "0.0.0.0/0"
    vpc_peering_connection_id = aws_vpc_peering_connection.peer.id
  }
}
# {/fact}
