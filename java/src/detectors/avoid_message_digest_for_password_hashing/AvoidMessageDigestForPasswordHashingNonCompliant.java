// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-avoid-message-digest-for-password-hashing@v1.0 defect=1}
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class AvoidMessageDigestForPasswordHashingNonCompliant{
    String PASSWORD = "Pass@123";
    //NonCompliant : `java.security.MessageDigest` used for password hashing.
    public void nonCompliant() throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] bytes = md5.digest(PASSWORD.getBytes());
    }
}
// {/fact}