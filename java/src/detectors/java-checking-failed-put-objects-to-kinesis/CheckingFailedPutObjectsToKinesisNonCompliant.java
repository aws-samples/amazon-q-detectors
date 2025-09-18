// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-checking-failed-put-objects-to-kinesis@v1.0 defects=1}
import com.amazonaws.services.kinesis.AmazonKinesis;
import com.amazonaws.services.kinesis.model.PutRecordsRequest;
import com.amazonaws.services.kinesis.model.PutRecordsResult;

public class CheckingFailedPutObjectsToKinesisNonCompliant {
    AmazonKinesis kinesisClient;
    PutRecordsRequest putRecsRequest;

    // Noncompliant: No check was performed on PutRecordsResult to verify there is no failed records before returning result.
    public void nonCompliant() {
        PutRecordsResult result = kinesisClient.putRecords(putRecsRequest);
        System.out.println("Put Result" + result);
    }
}
// {/fact}
