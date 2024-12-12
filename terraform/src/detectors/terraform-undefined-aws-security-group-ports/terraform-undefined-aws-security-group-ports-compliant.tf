# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-undefined-aws-security-group-ports@v1.0 defects=0}
resource "aws_security_group" "security_group" {
  name        = "compliant-sg-1"
  description = "Compliant security group with specific port"
  vpc_id      = aws_vpc.main.id

  # Compliant: The AWS Security Group restricts traffic to specific ports and sources.
  ingress {
    from_port   = 443
    to_port     = 443
    protocol    = "tcp"
    cidr_blocks = ["10.0.0.0/8"]
    description = "Allow HTTPS traffic"
  }
}

resource "aws_instance" "test" {
  ami           = "data.aws_ami.ubuntu.id"
  instance_type = "t3.micro"
  security_groups = [aws_security_group.security_group.id]
  metadata_options {
    http_endpoint = "enabled"
    http_tokens   = "required"
  }
  monitoring = true
  ebs_optimized = true
  root_block_device {
    encrypted     = true
  }
  iam_instance_profile = "test"
}
# {/fact}
