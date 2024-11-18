# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-unencrypted-workspace-user-volumes-terrafrom@v1.0 defects=1}
resource "aws_workspaces_workspace" "pass" {
  bundle_id                      = ""
  directory_id                   = ""
  user_name                      = ""
  root_volume_encryption_enabled = true
  # Noncompliant: The workspace user volumes are not encrypted.
}
# {/fact}