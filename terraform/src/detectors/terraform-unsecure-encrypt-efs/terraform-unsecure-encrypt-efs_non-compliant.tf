# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-unsecure-encrypt-efs@v1.0 defects=1}
resource "aws_ecs_task_definition" "service" {
  family = "cloudrail-test-encryption"
  volume {
    name = "service-storage"

    efs_volume_configuration {
      # Noncompliant: Encryption in transit is not enabled for EFS volumes in ECS Task definitions.
      file_system_id = aws_efs_file_system.test.id
      root_directory = "/opt/data"
    }
  }
  container_definitions = ""
}
# {/fact}