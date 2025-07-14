# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-hardcoded-credentials-library-ide@v1.0 defects=0}
require 'aws-sdk-s3'

class S3Service
  def compliant
    # Compliant: Using environment variables or IAM roles for AWS credentials.
    s3_client = Aws::S3::Client.new(
      access_key_id: ENV['AWS_ACCESS_KEY_ID'],
      secret_access_key: ENV['AWS_SECRET_ACCESS_KEY'],
      region: ENV['AWS_REGION'] || 'us-west-2'
    )
    s3_client
  end
end
# {/fact}
