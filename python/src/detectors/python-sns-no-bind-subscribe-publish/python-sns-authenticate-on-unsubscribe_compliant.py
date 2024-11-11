#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-sns-no-bind-subscribe-publish@v1.0 defects=0}
import boto3

def sns_publish_compliant(self, sqs_arn: str, topic_arn: str):
    session = boto3.Session()
    sns_client = session.client('sns')
    response = sns_client.subscribe(
        TopicArn=topic_arn,
        Protocol='sqs',
        Endpoint=sqs_arn,
        ReturnSubscriptionArn=True
    )
    # Compliant: Avoids binding of SNS publish operations with subscribe() or create_topic() operations.
    return response
# {/fact}
