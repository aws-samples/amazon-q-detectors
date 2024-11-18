# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-disabled-msk-cluster-and-in-transit@v1.0 defects=0}
resource "aws_msk_cluster" "example" {
  cluster_name           = "example"

  # Compliant: Encryption in transit is enabled for the AWS MSK cluster.
  encryption_info {
    encryption_at_rest_kms_key_arn = aws_kms_key.kms.arn

    encryption_in_transit {
      client_broker = "TLS"
      in_cluster    = true
    }
  }
  logging_info {
    broker_logs {
      cloudwatch_logs {
        enabled   = true
        log_group = aws_cloudwatch_log_group.test.name
      }
    }
  }

  kafka_version          = ""
  number_of_broker_nodes = 0
}
# {/fact}