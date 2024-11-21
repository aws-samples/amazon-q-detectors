# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-unencrypted-workspace-root-volumes@v1.0 defects=1}
resource "aws_workspaces_workspace" "pass" {
    bundle_id    = ""
    directory_id = ""
    user_name    = ""

    # Noncompliant: The workspace root volumes are not encrypted.
    root_volume_encryption_enabled = false
    user_volume_encryption_enabled = true
}
# {/fact}