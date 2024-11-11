// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-overly-permissive-file-permission-obj@v1.0 defects=0}
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.attribute.PosixFilePermissions

class IncorrectPermissionAssignmentCompliant {

  @throws[IOException]
  def incorrectPermissionAssignmentCompliant(path: Path): Unit = {
    // Compliant: Permissions are more restrictive.
    val perms = PosixFilePermissions.fromString("rw-r-----")
    Files.setPosixFilePermissions(path, perms)
  }

}
// {/fact}
