# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-deprecated-get-configuration@v1.0 defects=1}
require 'aws-sdk-appconfig'

def noncompliant
    appconfig = Aws::AppConfig::Client.new

    # Noncompliant: `get_configuration` has been deprecated.
    response = appconfig.get_configuration({
        application: 'my_application',
        environment: 'my_environment',
        configuration: 'my_configuration',
        client_id: 'my_client_id'
    })

    puts response.content
end
# {/fact}
