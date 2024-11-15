# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-disabled-aws-configuration@v1.0 defects=1}
resource "aws_config_configuration_aggregator" "organization" {
  name = "example"
  account_aggregation_source {
    account_ids = ["123456789012"]
    # Noncompliant: AWS Config is not enabled across all regions.
  }
}
# {/fact}