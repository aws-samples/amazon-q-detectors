// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-parsing-error-message@v1.0 defects=1}
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParsingErrorMessageNonCompliant {

    private AmazonS3Client s3Client;

    private static final Logger logger = LoggerFactory.getLogger(ParsingErrorMessageNonCompliant.class);

    // Noncompliant: Checks the availability of a component in exception message instead of the status code.
    public void nonCompliant() {
        try {
            s3Client.getObject("bucketName", "key");
        } catch (AmazonServiceException e) {
            if (e.getMessage().contains("bucketName")) {
                logger.info("one thing");
            } else {
                logger.info("another thinking");
            }
        }
    }
}
// {/fact}
