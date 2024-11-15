# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-disabled-msk-cluster-and-in-transit@v1.0 defects=1}
resource "aws_msk_cluster" "example" {
  cluster_name           = "example"

  # Noncompliant: Encryption in transit is disabled for the AWS MSK cluster.
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