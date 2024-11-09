// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-batch-write-output-ignored@v1.0 defects=0}
import com.amazonaws.services.sqs.model.BatchResultErrorEntry;
import com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.SendMessageBatchResult;
import java.util.List;
import java.util.stream.Collectors;

public class AwsBatchWriteOutputIgnoredCompliant {

    // Compliant: Batch write result is checked for errors, handling failed operations appropriately.
    public void compliant(final SqsClient amazonSqs,
                               final String sqsEndPoint,
                               final List<SendMessageBatchRequestEntry> batch)
            throws SQSUpdateException, CloneNotSupportedException {
        if (batch.isEmpty() || sqsEndPoint == null) {
            return;
        }
        SendMessageBatchResult sendResult =
                amazonSqs.sendMessageBatch(sqsEndPoint, batch);
        batch.clear();
        if (sendResult == null) {
            return;
        } else {
            final List<BatchResultErrorEntry> failed = sendResult.getFailed();
            if (!failed.isEmpty()) {
                final String failedMessage = failed.stream()
                        .map(batchResultErrorEntry -> String.format("messageId:%s failedReason:%s",
                                batchResultErrorEntry.getId(), batchResultErrorEntry.getMessage()))
                        .collect(Collectors.joining(","));
                throw new SQSUpdateException("Error occurred while sending messages to SQS::" + failedMessage);
            }
        }
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