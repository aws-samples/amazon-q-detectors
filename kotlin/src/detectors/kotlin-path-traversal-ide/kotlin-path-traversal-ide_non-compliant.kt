// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-path-traversal-ide@v1.0 defects=1}
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class FileController {
    
    @GetMapping("/download")
    fun downloadFile(@RequestParam filename: String): ByteArray {
        // Noncompliant: Using user input directly in file path without validation enables path traversal attacks.
        val file = File("/data/files/$filename")
        return Files.readAllBytes(file.toPath())
    }
    
    @GetMapping("/read")
    fun readFile(@RequestParam path: String): String {
        // Noncompliant: Using user input directly in file path without validation enables path traversal attacks.
        return Files.readString(Paths.get(path))
    }
}
// {/fact}
