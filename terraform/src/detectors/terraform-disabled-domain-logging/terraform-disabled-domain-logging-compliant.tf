# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-disabled-domain-logging@v1.0 defects=0}
resource "aws_elasticsearch_domain" "example" {
  domain_name           = "example"
  # Compliant: Logging is activated for the AWS Elasticsearch domain.
  log_publishing_options {
    cloudwatch_log_group_arn = aws_cloudwatch_log_group.example.arn
    log_type                 = "INDEX_SLOW_LOGS"
  }
  vpc_options {
    subnet_ids = [
      data.aws_subnet_ids.selected.ids[0],
      data.aws_subnet_ids.selected.ids[1],
    ]
    security_group_ids = ["sg_1234545"]
  }

  domain_endpoint_options {
    enforce_https       = true
    tls_security_policy = "Policy-Min-TLS-1-2-2019-07"
  }

  encrypt_at_rest {
    enabled = true
    kms_key_id = aws_kms_key.example.arn
  }
  cluster_config {
    dedicated_master_enabled = true
  }
  advanced_security_options {
    enabled                        = true
    internal_user_database_enabled = true
  }
}
# {/fact}
