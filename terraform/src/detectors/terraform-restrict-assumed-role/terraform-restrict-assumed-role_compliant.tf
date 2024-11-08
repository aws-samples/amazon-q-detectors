# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-restrict-assumed-role@v1.0 defects=0}
resource "aws_iam_role" "over-privilege-role2" {
  name = "over-privilege-role"

  # Compliant: Specific assume role policy principal is mentioned.
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
              "AWS": [
                "123456789012",
              ]
            },
            "Effect": "Allow",
            "Sid": ""
          }
        ]
      }
  EOF
}
# {/fact}