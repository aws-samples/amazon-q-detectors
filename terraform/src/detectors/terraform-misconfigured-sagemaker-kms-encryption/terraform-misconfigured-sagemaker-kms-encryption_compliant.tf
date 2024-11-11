# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-misconfigured-sagemaker-kms-encryption@v1.0 defects=0}
resource "aws_sagemaker_endpoint_configuration" "foo" {
  name = "terraform-sagemaker-example"
  # Compliant: All data stored in the Sagemaker Endpoint is securely encrypted at rest.
  kms_key_arn = aws_kms_key.examplea.arn
  production_variants {
    variant_name           = "variant-1"
    model_name             = aws_sagemaker_model.foo.name
    initial_instance_count = 1
    instance_type          = "ml.t2.medium"
    initial_variant_weight = 1
  }

  tags = {
    foo = "bar"
  }
}
# {/fact}