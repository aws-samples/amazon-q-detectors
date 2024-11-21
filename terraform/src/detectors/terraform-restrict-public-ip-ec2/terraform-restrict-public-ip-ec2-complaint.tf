# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-restrict-public-ip-ec2@v1.0 defects=0}
resource "aws_instance" "test" {
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
	# Compliant: AWS EC2 instances with public IP addresses and linked security groups do not have internet access.
	associate_public_ip_address = false
}
# {/fact}