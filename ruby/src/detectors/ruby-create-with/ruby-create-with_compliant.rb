# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-create-with@v1.0 defects=0}
def good_create_with
  # Compliant: Using `create_with` with permitted params to prevent mass assignment vulnerabilities.
  user.blog_posts.create_with(params[:blog_post].permit(:title, :body, :etc)).create
end
# {/fact}
