// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-unsafe-permission@v1.0 defects=1}
import java.lang.reflect.ReflectPermission
import java.security.CodeSource
import java.security.PermissionCollection
import java.security.Policy

class UnsafePermissionNoncompliant extends Policy {

  def unsafePermissionNoncompliant(cs: CodeSource): Unit = {
    val pc: PermissionCollection = super.getPermissions(cs)
    // Noncompliant: Granted potentially unsafe permission.
    pc.add(new ReflectPermission("suppressAccessChecks"))
  }

}
// {/fact}
