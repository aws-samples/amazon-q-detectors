# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-use-aws-certificate-ssl-elb@v1.0 defects=0}
resource "aws_elb" "sampletest" {
  name = "test-lb-tf"
  availability_zones = ["us-west-2a", "us-west-2b", "us-west-2c"]
  listener {
    instance_port     = 8000
    instance_protocol = "http"
    lb_port           = 80
    lb_protocol       = "http"
    # Compliant: Elastic Load Balancer is using SSL certificates provided by AWS Certificate Manager.
    ssl_certificate_id = "arn:aws:iam::123456789012:server-certificate/certName"
  }
  
  access_logs {
      enabled = True
      bucket  = aws_s3_bucket.lb_logs.bucket
    }
}
# {/fact}