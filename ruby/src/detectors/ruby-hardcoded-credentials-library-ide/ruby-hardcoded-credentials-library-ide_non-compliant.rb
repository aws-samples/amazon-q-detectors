# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-hardcoded-credentials-library-ide@v1.0 defects=1}
require 'aws-sdk-s3'

class S3Service
  def noncompliant
    # Noncompliant: Hardcoded AWS credentials in library configuration pose security risks.
    s3_client = Aws::S3::Client.new(
      access_key_id: 'AKIAIOSFODNN7EXAMPLE',
      secret_access_key: 'wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY',
      region: 'us-west-2'
    )
    s3_client
  end
end
# {/fact}
