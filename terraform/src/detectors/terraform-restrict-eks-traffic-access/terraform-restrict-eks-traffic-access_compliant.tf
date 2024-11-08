# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-restrict-eks-traffic-access@v1.0 defects=0}
resource "aws_eks_cluster" "test" {
  name = "test"
  role_arn = aws_iam_role.eksrole.arn
  vpc_config {
    subnet_ids = [aws_subnet.subnet1.id]
    # Compliant: `endpoint_public_access` is disabled to avoid traffic.
    endpoint_public_access = False
  }
  encryption_config {
    resources = ["secrets"]
  }
  enabled_cluster_log_types = [
    "api",
    "audit",
    "authenticator",
    "controllerManager",
    "scheduler"
  ]
}
# {/fact}