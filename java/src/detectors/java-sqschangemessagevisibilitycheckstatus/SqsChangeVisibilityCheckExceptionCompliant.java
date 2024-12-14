// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-sqschangemessagevisibilitycheckstatus@v1.0 defects=0}
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityRequest;
import com.amazonaws.services.sqs.model.MessageNotInflightException;
import lombok.extern.slf4j.Slf4j;
import static java.lang.String.format;

@Slf4j
public class SqsChangeVisibilityCheckExceptionCompliant {
    public void withCheck(AmazonSQS amazonSqsClient, ChangeMessageVisibilityRequest request) {
        // Compliant: `MessageNotInFlight` exception is checked when changing message visibility.
        try {
            amazonSqsClient.changeMessageVisibility(request);
        } catch (MessageNotInflightException ex) {
            log.info(format("Message with receipt handle already visible. Too late to abandon"));
        } catch (Exception ex) {
            log.error(format("Caught unknown exception"), ex);
        }
    }
}
// {/fact}
