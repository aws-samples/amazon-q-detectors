#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-use-lifecycle-configuration-for-s3-bucket@v1.0 defects=1}
from aws_cdk import (
    Stack,
    aws_s3 as s3,
)
from constructs import Construct
from ps2 import StepFunction


class TrainingWorkflow(Stack):
    def __init__(
        self,
        scope: Construct,
        construct_id: str,
        project_name: str,
        stage: str,
        **kwargs
    ) -> None:
        super().__init__(scope, construct_id, **kwargs)

        # Noncompliant: Lifecycle rules not configured.
        artifact_bucket = s3.Bucket(
            self,
            "WorkflowS3Bucket",
            bucket_name=f"{project_name}-artifacts-{stage}"
        )

        StepFunction(
            self,
            stage,
            project_name,
            workflow_name="training",
            definition=chain
        )
# {/fact}
