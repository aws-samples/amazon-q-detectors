# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-missing-pagination@v1.0 defects=1}
require 'aws-sdk-s3'

def noncompliant
  s3 = Aws::S3::Client.new
  
  # Noncompliant: Using `list_objects` without pagination can miss results beyond first 1000 objects.
  response = s3.list_objects(bucket: 'my-bucket')
  
  response.contents.each do |object|
    puts object.key
  end
end
# {/fact}
