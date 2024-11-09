// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-unsafe-permission@v1.0 defects=0}
import java.security.PermissionCollection
import java.security.Policy

class UnsafePermissionCompliant extends Policy {

  def unsafePermissionCompliant(pc: PermissionCollection): Unit = {
    // Compliant: Granted potentially safe permission.
    pc.add(new RuntimePermission("setFactory"))
  }

}
// {/fact}
