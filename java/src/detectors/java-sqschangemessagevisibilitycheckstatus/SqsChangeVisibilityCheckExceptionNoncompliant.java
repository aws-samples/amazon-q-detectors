// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-sqschangemessagevisibilitycheckstatus@v1.0 defects=1}
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SqsChangeVisibilityCheckExceptionNoncompliant {
    public void withoutCheck(AmazonSQS amazonSqsClient, ChangeMessageVisibilityRequest request) {
        // Noncompliant: `MessageNotInFlight` exception is not checked when changing message visibility.
        amazonSqsClient.changeMessageVisibility(request);
    }
}
// {/fact}
