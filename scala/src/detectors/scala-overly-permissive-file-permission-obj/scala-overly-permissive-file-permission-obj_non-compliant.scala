// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-overly-permissive-file-permission-obj@v1.0 defects=1}
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.attribute.PosixFilePermissions

class IncorrectPermissionAssignmentNoncompliant {

  @throws[IOException]
  def incorrectPermissionAssignmentNoncompliant(path: Path): Unit = {
    // Noncompliant: Permissions are not assigned correctly.
    val perms = PosixFilePermissions.fromString("rw-rw-rw-")
    Files.setPosixFilePermissions(path, perms)
  }

}
// {/fact}
