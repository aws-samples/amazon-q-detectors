# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-create-with@v1.0 defects=1}
def bad_create_with
  # Noncompliant: Using create_with with unpermitted params can lead to mass assignment vulnerabilities.
  user.blog_posts.create_with(params[:blog_post]).create
end
# {/fact}
