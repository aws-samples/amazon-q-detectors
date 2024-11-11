# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-restrict-eks-traffic-access@v1.0 defects=1}
resource "aws_eks_cluster" "test" {
  name = "test"
  role_arn = aws_iam_role.eksrole.arn
  vpc_config {
    subnet_ids = [aws_subnet.subnet1.id]
    # Noncompliant: `endpoint_public_access` is enabled, which allows public traffic.
    endpoint_public_access = True
  }
}
# {/fact}