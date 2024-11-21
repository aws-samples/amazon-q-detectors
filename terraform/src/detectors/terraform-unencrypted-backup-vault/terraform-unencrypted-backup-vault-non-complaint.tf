# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-unencrypted-backup-vault@v1.0 defects=1}
resource "aws_backup_vault" "backup_with_kms_key" {
  name          = ""
  # Noncompliant: The Backup Vault is not encrypted at rest with a KMS CMK.
}
# {/fact}