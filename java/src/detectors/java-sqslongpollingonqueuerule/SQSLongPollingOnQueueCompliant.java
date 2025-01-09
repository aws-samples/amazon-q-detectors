// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-sqslongpollingonqueuerule@v1.0 defects=0}
package com.amazon.sqs;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.CreateQueueResult;
import com.amazonaws.services.sqs.model.QueueDeletedRecentlyException;
import com.amazonaws.services.sqs.model.QueueNameExistsException;

public class SQSLongPollingOnQueueCompliant {

    public static void main(String[] args) {

        final AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
        String queueNamePattern = "sqs-poc-fifo-queue";
        int numOfQueues = 6;
        createQueues(sqs, queueNamePattern, numOfQueues);
    }

    /**
     * Create FIFO queues based on the Queue Name pattern and the number of queues
     * needed
     *
     * @param sqs
     * @param queueNamePattern
     * @param numOfQueues
     */
    public static void createQueues(AmazonSQS sqs, String queueNamePattern, int numOfQueues) {

        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("FifoQueue", "true");
        attributes.put("ContentBasedDeduplication", "true");
        attributes.put("DelaySeconds", "0");
        attributes.put("MessageRetentionPeriod", "86400");

        for (int i = 1; i < numOfQueues + 1; i++) {
            String queueName = queueNamePattern + "-" + i + ".fifo";
            CreateQueueRequest createQueueRequest = new CreateQueueRequest(queueName).withAttributes(attributes);
            try {
                CreateQueueResult res = sqs.createQueue(createQueueRequest);
                System.out.println("SQS Queue created, queue url: " + res.getQueueUrl());
            } catch (QueueNameExistsException e) {
                System.out.println("A queue with name " + queueName
                                           + " already exist. Renaming it with _v1 suffix before next attempt");
                queueName = queueNamePattern + "-" + i + "-v1" + "-src.fifo";
                createQueueRequest = new CreateQueueRequest(queueName).withAttributes(attributes);
                sqs.createQueue(createQueueRequest);

            } catch (QueueDeletedRecentlyException e) {
                try {
                    System.out.println(e.getMessage());
                    System.out.println("Queue recently deleted. Sleeping for 65 seconds before recreating the queue");
                    Thread.sleep(65000);
                    createQueueRequest = new CreateQueueRequest(queueName).withAttributes(attributes);
                    sqs.createQueue(createQueueRequest);

                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            // Compliant: Set the wait time in seconds on the `ReceiveMessageRequest` object to enable long polling.
            ReceiveMessageRequest receive_request = new ReceiveMessageRequest()
                                                            .withQueueUrl(queue_url)
                                                            .withWaitTimeSeconds(20); 
            sqs.receiveMessage(receive_request);

        }

    }
}
// {/fact}