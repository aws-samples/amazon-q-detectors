# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-missing-pagination@v1.0 defects=0}
require 'aws-sdk-s3'

def compliant
  s3 = Aws::S3::Client.new
  
  # Compliant: Using each method to handle pagination automatically.
  s3.list_objects(bucket: 'my-bucket').each do |response|
    response.contents.each do |object|
      puts object.key
    end
  end
end
# {/fact}
