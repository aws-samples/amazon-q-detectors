// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-client-constructor-deprecated@v1.0 defects=1}
import com.amazonaws.services.kinesis.AmazonKinesisClient;

public class ClientConstructorDeprecatedRuleNonCompliant {

    // Noncompliant: Deprecated AmazonKinesisClient constructor used instead of recommended builder pattern.
    public void nonCompliant(){
        AmazonKinesisClient producerKinesisClient = new AmazonKinesisClient();
    }
}
// {/fact}