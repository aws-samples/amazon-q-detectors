# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-sns-topic-uses-cmk@v1.0 defects=1}
resource "aws_sns_topic" "topic_1" {
  name = "topic-1"
  # Noncompliant: The AWS SNS topic has SSE (Server-Side Encryption) disabled.
}
# {/fact}