# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-restrict-sqs-asterisk-action@v1.0 defects=1}
resource "aws_sqs_queue_policy" "allow_email_notification_events" {
  count = local.emailing_enabled

  queue_url = aws_sqs_queue.email_events[0].id

  # Noncompliant: SQS policy have ALL (*) actions.
  policy = <<-EOP
  {
      "Version": "2012-10-17",
      "Id": "${aws_sqs_queue.email_events[0].arn}/SQSDefaultPolicy",
      "Statement": [
          {
              "Effect": "Allow",
              "Principal": {
                 "AWS": "*"
              },
              "Action": "*",
              "Resource": "${aws_sqs_queue.email_events[0].arn}",
              "Condition": {
                  "ArnEquals": {
                      "aws:SourceArn": "${aws_sns_topic.email_notifications[0].arn}"
                  }
              }
          }
      ]
  }
  EOP
}
# {/fact}