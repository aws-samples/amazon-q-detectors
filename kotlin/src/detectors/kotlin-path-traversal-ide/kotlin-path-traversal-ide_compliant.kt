// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-path-traversal-ide@v1.0 defects=0}
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.apache.commons.io.FilenameUtils

@RestController
class FileController {
    
    @GetMapping("/download")
    fun compliant(@RequestParam filename: String): ByteArray {
        // Compliant: Sanitizing user input by extracting only the filename and validating against allowed files.
        val sanitizedFilename = FilenameUtils.getName(filename)
        val allowedFiles = setOf("report.pdf", "document.txt", "image.png")
        
        if (!allowedFiles.contains(sanitizedFilename)) {
            throw SecurityException("Access denied to requested file")
        }
        
        val file = File("/data/files/$sanitizedFilename")
        return Files.readAllBytes(file.toPath())
    }
}
// {/fact}
