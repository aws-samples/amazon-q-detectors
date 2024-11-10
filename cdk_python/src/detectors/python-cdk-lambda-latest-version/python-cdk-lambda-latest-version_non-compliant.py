# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-lambda-latest-version@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_lambda import CfnFunction, Runtime

class CdkStarterself(cdk.self):
  def __init__(self, scope: cdk.App, id: str):
    super(scope, id)

    # Noncompliant: Lambda function is not using the latest runtime version.
    CfnFunction(self, 'rFunction', 
    runtime = str(Runtime.NODEJS_16_X),
    code = CfnFunction.CodeProperty(
        s3_bucket="s3Bucket"
    ),
    role = 'somerole'
    )
   