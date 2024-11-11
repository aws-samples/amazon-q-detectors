# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-exposed-lambda-env-secret@v1.0 defects=0}
resource "aws_lambda_function" "IdempotencyFunction" {
  function_name = "IdempotencyFunction"
  role          = aws_iam_role.IdempotencyFunctionRole.arn
  runtime       = "python3.11"
  handler       = "app.lambda_handler"
  # Compliant: No hardcoded secrets in lambda environment.
  filename      = "lambda.zip"
  environment {}
  kms_key_arn = aws_kms_key.anyoldguff.arn
  code_signing_config_arn = "123123123"
  reserved_concurrent_executions = 100
  tracing_config {
    mode = "Active"
  }
  vpc_config {
    subnet_ids         = [aws_subnet.subnet_for_lambda.id]
    security_group_ids = [aws_security_group.sg_for_lambda.id]
  }
  dead_letter_config {
    target_arn = "test"
  }
}
# {/fact}