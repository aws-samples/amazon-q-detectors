# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-restrict-iam-admin-policy@v1.0 defects=0}
resource "aws_iam_policy" "ec2_pricing" {
  name        = "ec2_pricing"
  description = "allow access to ec2 instance types and pricing information"
  path        = "/"
  policy = jsonencode({
    Version = "2012-10-17"
    # Compliant: IAM policies that allow full "*-*" administrative privileges is not created.
    Statement = [
      {
        Effect = "Allow"
        Action = [
          "ec2:DescribeInstanceTypes",
          "ec2:DescribeRegions",
          "pricing:*",
          "elasticache:DescribeEngineDefaultParameters"
        ],
        Resource = "*"
      }
    ]
  })
  tags = {
    Terraformed = "true"
  }
}
# {/fact}