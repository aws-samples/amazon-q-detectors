#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-sns-no-bind-subscribe-publish@v1.0 defects=1}
import boto3

def sns_publish_noncompliant(self, sqs_arn: str, topic_arn: str):
    session = boto3.Session()
    sns_client = session.client('sns')
    sns_client.subscribe(
        TopicArn=topic_arn,
        Protocol='sqs',
        Endpoint=sqs_arn,
        ReturnSubscriptionArn=True
    )

    # Noncompliant: Incorrect binding of SNS publish operations with subscribe() or create_topic() operations.
    sns_client.publish(
        TopicArn=topic_arn,
        Message='test message for SQS',
        MessageAttributes={
            'attr1': {
                'DataType': 'String',
                'StringValue': "short_uid"
             }
        }
    )
# {/fact}
