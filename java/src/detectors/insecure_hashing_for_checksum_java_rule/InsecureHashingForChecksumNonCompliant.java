// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-insecure-hashing-for-checksum@v1.0 defects=1}
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class InsecureHashingForChecksumNonCompliant {

    // Noncompliant: SHA-1 used for hashing, which is considered insecure for cryptographic purposes due to collision vulnerabilities.
    public void nonCompliant() throws IOException, NoSuchAlgorithmException {
        byte[] b = Files.readAllBytes(Paths.get("/path/to/file"));
        byte[] hash = MessageDigest.getInstance("SHA1").digest(b);
    }
}
// {/fact}