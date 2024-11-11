# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-unsecured-sagemaker-data@v1.0 defects=0}
resource "aws_sagemaker_notebook_instance" "ni" {
  name          = "my-notebook-instance"
  role_arn      = aws_iam_role.test_role.arn
  instance_type = "ml.t2.medium"
  root_access = "Disabled"
  subnet_id = aws_subnet.pike.id
  # Compliant: SageMaker Notebook is encrypted at rest using KMS CMK.
  kms_key_id    = "1234abcd-12ab-34cd-56ef-1234567890ab"

  tags = {
    Name = "foo"
  }
}
# {/fact}