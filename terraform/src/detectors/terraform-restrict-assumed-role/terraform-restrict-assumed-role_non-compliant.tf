# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-restrict-assumed-role@v1.0 defects=1}
resource "aws_iam_role" "over-privilege-role1" {
  name = "over-privilege-role"

  # Noncompliant: Specific assume role policy principal is not mentioned.
  assume_role_policy = <<EOF
      {
        "Version": "2012-10-17",
        "Statement": [
          {
            "Action": "sts:AssumeRole",
            "Principal": {
              "Service": "ec2.amazonaws.com"
            },
            "Effect": "Allow",
            "Sid": ""
          },
          {
            "Action": "sts:AssumeRole",
            "Principal": {
              "AWS": "*"
            },
            "Effect": "Allow",
            "Sid": ""
          }
        ]
      }
  EOF
}
# {/fact}