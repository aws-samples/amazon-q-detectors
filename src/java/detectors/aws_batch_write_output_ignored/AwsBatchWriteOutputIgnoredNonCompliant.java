// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-batch-write-output-ignored@v1.0 defects=1}
import com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.SendMessageBatchResult;
import java.util.List;

public class AwsBatchWriteOutputIgnoredNonCompliant {

    // NonCompliant: Batch write result not checked for errors, potentially ignoring failed operations.
    public void nonCompliant(final SqsClient amazonSqs,
                                  final String sqsEndPoint,
                                  final List<SendMessageBatchRequestEntry> batch)
            throws CloneNotSupportedException {
        if (batch.isEmpty()) {
            return;
        }
        SendMessageBatchResult sendResult =
                amazonSqs.sendMessageBatch(sqsEndPoint, batch);
        batch.clear();
    }

    public class SqsClient {
        public SendMessageBatchResult sendMessageBatch(String sqsEndPoint, List<SendMessageBatchRequestEntry> batch)
                throws CloneNotSupportedException {
            SendMessageBatchResult result = (SendMessageBatchResult) clone();
            return result;
        }
    }

    private class SQSUpdateException extends Throwable {
        public SQSUpdateException(String s) {
        }
    }
}
// {/fact}
