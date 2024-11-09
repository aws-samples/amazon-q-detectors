// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-do-not-catch-and-throw-exception@v1.0 defect=0}
import com.amazonaws.AmazonServiceException;
import lombok.extern.slf4j.Slf4j;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;

import javax.servlet.ServletException;

@Slf4j
public class DoNotCatchAndThrowExceptionCompliant {

    // Compliant: Exception caught, logged, and rethrown without modification, preserving original stack trace.
    public void compliant() throws ServletException {
        try {
            foo();
        } catch (Exception t) {
            log.warn("Exception :", t);
            throw t;
        }
    }

    void foo() {
    }
}
// {/fact}