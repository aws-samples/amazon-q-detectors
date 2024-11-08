// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-client-constructor-deprecated@v1.0 defects=0}
import com.amazonaws.services.kinesis.AmazonKinesis;
import com.amazonaws.services.kinesis.AmazonKinesisClientBuilder;

public class ClientConstructorDeprecatedRuleCompliant {

    // Compliant: AmazonKinesisClientBuilder used to create client.
    public void compliant(String region) {
        AmazonKinesis kinesis = AmazonKinesisClientBuilder.standard().withRegion(region).build();
    }
}
// {/fact}
