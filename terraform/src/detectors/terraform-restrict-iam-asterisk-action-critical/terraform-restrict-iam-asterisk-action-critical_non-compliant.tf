# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-restrict-iam-asterisk-action-critical@v1.0 defects=1}
resource "aws_iam_policy" "LambdaDynamoDBPolicy" {
  name        = "LambdaDynamoDBPolicy"
  description = "IAM policy for Lambda function to access DynamoDB"
  policy = jsonencode({
    Version = "2012-10-17"
    Statement = [
      {
        Sid    = "AllowDynamodbReadWrite"
        Effect = "Allow"
        # Noncompliant: IAM policies documents allow "*" as a statement's actions.
        Action = [
          "*"
        ]
        Resource = aws_dynamodb_table.IdempotencyTable.arn
      },
    ]
  })
}
# {/fact}