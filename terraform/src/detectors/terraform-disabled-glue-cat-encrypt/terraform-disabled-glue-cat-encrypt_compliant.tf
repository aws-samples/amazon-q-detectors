# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-disabled-glue-cat-encrypt@v1.0 defects=0}
resource "aws_glue_data_catalog_encryption_settings" "examplea" {
  data_catalog_encryption_settings {
    connection_password_encryption {
      aws_kms_key_id = var.kms_key.id
      return_connection_password_encrypted = true
    }

    # Compliant: Glue Data Catalog Encryption is enabled.
    encryption_at_rest {
      catalog_encryption_mode = "SSE-KMS"
      sse_aws_kms_key_id = var.kms_key.id
    }
  }
}
# {/fact}