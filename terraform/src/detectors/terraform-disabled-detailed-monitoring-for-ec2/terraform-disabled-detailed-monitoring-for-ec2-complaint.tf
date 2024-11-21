# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-disabled-detailed-monitoring-for-ec2@v1.0 defects=0}
resource "aws_instance" "test" {
  # Compliant: Detailed monitoring is enabled for the AWS EC2 instance.
  monitoring = true
  ami        = ""
  instance_type = ""
  iam_instance_profile = "test"

  metadata_options {
    http_endpoint = "enabled"
    http_tokens   = "required"
  }
  ebs_optimized = true
  root_block_device {
    encrypted     = true
  }
}
# {/fact}