#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-detect-hardcoded-aws-credentials@v1.0 defects=1}
import boto3

def create_session_noncompliant():
    # Noncompliant: Uses hardcoded secret access key.
    aws_access_key_id = "BjWnyxxxxx45xxxxZxxxX7ZQxxxxYxxx1xYxxxxx"
    aws_secret_access_key = "AjWnyxxxxx45xxxxZxxxX7ZQxxxxYxxx1xYxxxxx"
    aws_session_token = "CjWnyxxxxx45xxxxZxxxX7ZQxxxxYxxx1xYxxxxx"

    session = boto3.session.Session(
        aws_access_key_id=aws_access_key_id,
        aws_secret_access_key=aws_secret_access_key,
        aws_session_token=aws_session_token
    )
# {/fact}
