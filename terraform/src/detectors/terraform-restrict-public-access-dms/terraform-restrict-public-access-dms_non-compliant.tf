# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-restrict-public-access-dms@v1.0 defects=1}
resource "aws_dms_replication_instance" "test" {
  allocated_storage            = 20
  apply_immediately            = true
  auto_minor_version_upgrade   = true
  multi_az                     = false
  preferred_maintenance_window = "sun:10:30-sun:14:30"
  # Noncompliant: DMS replication instance is publicly accessible.
  publicly_accessible          = true
  replication_instance_class   = "dms.t2.micro"
  replication_instance_id      = "test-dms-replication-instance-tf"
  replication_subnet_group_id  = aws_dms_replication_subnet_group.test.id
  kms_key_arn                  = test

  tags = {
    Name = "test"
  }

}
# {/fact}
