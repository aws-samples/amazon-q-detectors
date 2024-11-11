# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-implicit-eks-ssh-access@v1.0 defects=1}
resource "aws_eks_node_group" "private-node-group-1-tf" {
  cluster_name  = aws_eks_cluster.eks-tf.name
  node_group_name = format("%s-private-ng-1-%s", local.project_prefix, local.build_suffix)
  node_role_arn  = aws_iam_role.workernodes.arn
  subnet_ids =  [for i in aws_subnet.eks-internal: i.id]
  instance_types = ["t3.small"]
  # Noncompliant: No `source_security_group_ids` has been configured.
  remote_access {
    ec2_ssh_key = "some-key"
  }
  scaling_config {
    desired_size = 0
    max_size     = 0
    min_size     = 0
  }
}
# {/fact}