// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-lack-of-file-extension-validation@v1.0 defects=1}
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.File
import java.nio.file.Files
import java.nio.file.StandardCopyOption

fun lack_of_file_extension_validation_noncompliant(request: HttpServletRequest, response: HttpServletResponse) {
    // Noncompliant: No validation of file extension before processing uploaded file.
    val filePart = request.getPart("fileToUpload")
    val fileInputStream = filePart.inputStream
    val fileToSave = File("uploads/" + filePart.submittedFileName)
    Files.copy(fileInputStream, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING)
    response.outputStream.println("File was uploaded successfully.")
}
// {/fact}
