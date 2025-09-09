// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-checking-failed-put-objects-to-kinesis@v1.0 defects=0}
import com.amazonaws.services.kinesis.AmazonKinesis;
import com.amazonaws.services.kinesis.model.PutRecordsRequest;
import com.amazonaws.services.kinesis.model.PutRecordsResult;

public class CheckingFailedPutObjectsToKinesisCompliant {

    // Compliant: Failed record is checked in PutRecordsResult to verify there is no failed records before returning result.
    public PutRecordsResult compliant(AmazonKinesis kinesis, PutRecordsRequest putRecsReq) {
        PutRecordsResult result = kinesis.putRecords(putRecsReq);
        if (result.getFailedRecordCount() > 0)
            return kinesis.putRecords(putRecsReq);
        else
            return result;
    }
}
// {/fact}
