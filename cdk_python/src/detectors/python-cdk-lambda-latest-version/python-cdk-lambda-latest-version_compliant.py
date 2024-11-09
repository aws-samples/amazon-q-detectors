# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-lambda-latest-version@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_lambda import Code, Function

class CdkStarterself(cdk.self):
  def __init__(self, scope: cdk.App, id: str):
    super(scope, id)

    # Compliant: Lambda functions uses the latest runtime version.
    Function(self, 'rFunction', 
    runtime = get_latest_runtime('nodejs'),
    code = Code.from_asset('hi'),
    handler = 'index.handler'
    )
    # {/fact}
