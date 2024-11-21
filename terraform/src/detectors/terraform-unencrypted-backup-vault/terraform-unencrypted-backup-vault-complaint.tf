# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-unencrypted-backup-vault@v1.0 defects=0}
resource "aws_backup_vault" "backup_with_kms_key" {
  name          = ""
  # Compliant: The Backup Vault is encrypted at rest with a KMS CMK.
  kms_key_arn = aws_kms_key.example.arn
}
# {/fact}