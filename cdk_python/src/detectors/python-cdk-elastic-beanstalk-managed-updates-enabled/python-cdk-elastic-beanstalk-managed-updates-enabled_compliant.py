# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-elastic-beanstalk-managed-updates-enabled@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_elasticbeanstalk import CfnEnvironment

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id) 

        # Compliant: Specifies `UpdateLevel: minor`, ensuring only non-disruptive updates are applied to the environment.
        CfnEnvironment(self, 'rBeanstalk', 
            application_name = 'foo',
            option_settings = [
                CfnEnvironment.OptionSettingProperty(
                    namespce ='aws:elasticbeanstalk:managedactions',
                    option_name= 'ManagedActionsEnabled',
                    namespce ='aws:elasticbeanstalk:managedactions',
                    option_name= 'PreferredStartTime',
                    value = 'Tue:09:00',
                    namespce ='aws:elasticbeanstalk:managedactions:platformupdate',
                    option_name= 'UpdateLevel',
                    value = 'minor'
                )
            ]
        )
#{/fact}
