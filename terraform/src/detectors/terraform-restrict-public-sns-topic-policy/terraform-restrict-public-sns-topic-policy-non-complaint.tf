# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-restrict-public-sns-topic-policy@v1.0 defects=1}
resource "aws_sns_topic_policy" "sns_tp1" {
  # Noncompliant: The SNS topic policy is public and lacks restrictions to specific services or principals.
  policy = <<POLICY
  {
    "Version":"2012-10-17",
    "Statement":[
       {
          "Principal": "*",
          "Effect": "Allow",
          "Action": [
            "SNS:Subscribe",
            "SNS:SetTopicAttributes",
            "SNS:RemovePermission",
            "SNS:Receive",
            "SNS:Publish",
            "SNS:ListSubscriptionsByTopic",
            "SNS:GetTopicAttributes",
            "SNS:DeleteTopic",
            "SNS:AddPermission"
          ],
          "Resource": "${aws_sns_topic.test.arn}"
       }
    ]
  }
  POLICY
  arn    = ""
}
# {/fact}