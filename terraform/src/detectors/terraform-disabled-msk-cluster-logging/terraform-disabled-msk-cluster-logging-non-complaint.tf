# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-disabled-msk-cluster-logging@v1.0 defects=1}
resource "aws_msk_cluster" "example" {
  cluster_name           = "example"

  encryption_info {
    encryption_at_rest_kms_key_arn = aws_kms_key.kms.arn

    encryption_in_transit {
      client_broker = "TLS"
      in_cluster    = true
    }
  }
  # Noncompliant: Logging is disabled for the Amazon MSK cluster.


  kafka_version          = ""
  number_of_broker_nodes = 0
}
# {/fact}