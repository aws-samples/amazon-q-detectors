# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-restrict-public-sns-topic-policy@v1.0 defects=0}
resource "aws_sns_topic_policy" "sns_tp1" {
  # Compliant: The SNS topic policy is private and restricted to specific services or principals.
  policy = <<POLICY
  {
    "Version":"2012-10-17",
    "Statement":[
       {
          "Principal": "*",
          "Effect": "Deny",
          "Action": [
            "SNS:Subscribe",
            "SNS:SetTopicAttributes",
            "SNS:RemovePermission",
            "SNS:Receive",
            "SNS:Publish",
            "SNS:ListSubscriptionsByTopic",
            "SNS:GetTopicAttributes",
            "SNS:DeleteTopic",
            "SNS:AddPermission",
          ],
          "Resource": "${aws_sns_topic.test.arn}"
       }
    ]
  }
  POLICY
  arn    = ""
}
# {/fact}