# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-exposed-lambda-env-secret@v1.0 defects=1}
resource "aws_lambda_function" "LambdaFunction" {
  function_name = "IdempotencyFunction"
  role          = aws_iam_role.IdempotencyFunctionRole.arn
  runtime       = "python3.11"
  handler       = "app.lambda_handler"
  filename      = "lambda.zip"
  # Noncompliant: Hard-coded secrets in lambda environment.
  environment {
    variables = {
      AWS_ACCESS_KEY_ID     = "AKIAIOSFODNN7EXAMPLE",
      AWS_SECRET_ACCESS_KEY = "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY",
      AWS_DEFAULT_REGION    = "us-west-2"
    }
  }
  kms_key_arn = aws_kms_key.anyoldguff.arn
  reserved_concurrent_executions = 100
  code_signing_config_arn = "123123123"
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