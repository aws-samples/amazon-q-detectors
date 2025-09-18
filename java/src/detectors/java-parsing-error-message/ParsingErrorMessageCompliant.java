// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-parsing-error-message@v1.0 defects=0}
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParsingErrorMessageCompliant {

    private AmazonS3Client s3Client;
    private static final Logger logger = LoggerFactory.getLogger(ParsingErrorMessageCompliant.class);

    // Compliant: Checks the status code of the exception instead of the status message.
    public void compliant() {
        try {
            s3Client.getObject("bucketName", "key");
        } catch (AmazonServiceException e) {
            if (e.getStatusCode() == 404){
                logger.info("The specified bucket does not exist.");
            }
            else {
                logger.info("Caught error: " + e.getMessage());
            }

        }
    }
}
