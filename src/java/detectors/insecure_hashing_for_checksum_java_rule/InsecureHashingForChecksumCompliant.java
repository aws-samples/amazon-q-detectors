// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-insecure-hashing-for-checksum@v1.0 defect=0}
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class InsecureHashingForChecksumCompliant {
    // Compliant: SHA-512 used for hashing, which is a secure cryptographic hash function.
    public void compliant() throws IOException, NoSuchAlgorithmException {
        byte[] b = Files.readAllBytes(Paths.get("/path/to/file"));
        byte[] hash = MessageDigest.getInstance("SHA-512").digest(b);
    }
}
// {/fact}