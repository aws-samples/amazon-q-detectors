// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-lack-of-file-extension-validation@v1.0 defects=0}
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.File
import java.nio.file.Files
import java.nio.file.StandardCopyOption

fun lack_of_file_extension_validation_compliant(request: HttpServletRequest, response: HttpServletResponse) {
    // Compliant: Validating file extension before processing uploaded file.
    val filePart = request.getPart("fileToUpload")
    val fileName = filePart.submittedFileName
    val fileExtension = fileName.substringAfterLast(".")
    val allowedExtensions = listOf("pdf", "doc", "docx", "jpg", "png")
    
    if (allowedExtensions.contains(fileExtension.toLowerCase())) {
        val fileInputStream = filePart.inputStream
        val fileToSave = File("uploads/$fileName")
        Files.copy(fileInputStream, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING)
        response.outputStream.println("File was uploaded successfully.")
    } else {
        response.outputStream.println("Invalid file type. Please upload a valid file.")
    }
}
// {/fact}
