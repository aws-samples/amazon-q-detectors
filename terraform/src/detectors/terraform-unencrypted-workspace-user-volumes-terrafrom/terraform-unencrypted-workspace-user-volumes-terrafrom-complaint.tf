# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-unencrypted-workspace-user-volumes-terrafrom@v1.0 defects=0}
resource "aws_workspaces_workspace" "pass" {
  bundle_id                      = ""
  directory_id                   = ""
  user_name                      = ""
  root_volume_encryption_enabled = true
  # Compliant: The workspace user volumes are encrypted.
  user_volume_encryption_enabled = true
}
# {/fact}