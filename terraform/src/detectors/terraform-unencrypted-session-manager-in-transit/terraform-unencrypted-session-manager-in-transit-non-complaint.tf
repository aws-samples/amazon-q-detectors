# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-unencrypted-session-manager-in-transit@v1.0 defects=1}
resource "aws_ssm_document" "session_manager_compliant" {
  name            = "SSM-SessionManagerRunShell-Compliant"
  document_type   = "Session"
  document_format = "JSON"

  content = jsonencode({
    schemaVersion = "1.0"
    description   = "Document for Session Manager with encryption"
    sessionType   = "Standard_Stream"
    inputs = {
      s3BucketName                = "session-logs-bucket"
      s3KeyPrefix                 = "logs/"
      s3EncryptionEnabled        = true
      cloudWatchLogGroupName     = "/aws/sessionmanager/logs"
      cloudWatchEncryptionEnabled = true
      # Noncompliant: Session Manager data is not encrypted during transit.
    }
  })
}
# {/fact}