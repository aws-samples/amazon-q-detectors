# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-deprecated-get-configuration@v1.0 defects=0}

require 'aws-sdk-appconfig'

def compliant
    appconfig = Aws::AppConfig::Client.new

    # Compliant: Recommended api method has been used.
    response = appconfig.get_latest_configuration({
        application: 'my_application',
        environment: 'my_environment',
        configuration: 'my_configuration',
        client_id: 'my_client_id'
    })

    puts response.content
end
# {/fact}
