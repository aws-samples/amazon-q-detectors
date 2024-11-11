# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-unsecure-encrypt-efs@v1.0 defects=0}
resource "aws_ecs_task_definition" "service" {
  family = "cloudrail-test-encryption"
  volume {
    name = "service-storage"

    efs_volume_configuration {
      file_system_id = aws_efs_file_system.test.id
      root_directory = "/opt/data"
      # Compliant: Encryption in transit is enabled for EFS volumes in ECS Task definitions.
      transit_encryption = "ENABLED"
    }
  }
  container_definitions = ""
}
# {/fact}