# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-avoid-hardcoded-credentials@v1.0 defects=1}
provider "aws" {
  # Noncompliant: Hard coded AWS access key and secret key exists in provider.
  access_key = "AKIAIOSFODNN7EXAMPLE"
  secret_key = "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY"
  region     = "us-west-1"
}
# {/fact}