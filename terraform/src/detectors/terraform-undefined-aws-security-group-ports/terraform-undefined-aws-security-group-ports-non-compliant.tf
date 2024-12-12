# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-undefined-aws-security-group-ports@v1.0 defects=1}
resource "aws_security_group" "security_group" {
  name        = "non-compliant-sg-1"
  description = "Non-compliant security group with all ports open"
  vpc_id      = aws_vpc.main.id

  # Noncompliant: The AWS Security Group allows all traffic on all ports.
  ingress {
    from_port   = -1
    to_port     = -1
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
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
