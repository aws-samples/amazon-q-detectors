// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-dynamomapperencryptionsavebehavior@v1.0 defects=1}
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.DynamoDBEncryptor;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.providers.DirectKmsMaterialProvider;
import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DynamoMapperEncryptionSaveBehaviorNoncompliant {
    Region region = Region.getRegion(Regions.US_WEST_2);
    AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.standard().withRegion(String.valueOf(region)).build();
    AWSKMS kms = AWSKMSClientBuilder.standard().withRegion(String.valueOf(region)).build();
    DirectKmsMaterialProvider cmp = new DirectKmsMaterialProvider(kms);
    DynamoDBEncryptor encryptor = DynamoDBEncryptor.getInstance(cmp);
    AttributeEncryptor attributeEncryptor = new AttributeEncryptor(encryptor);

    // Noncompliant: DynamoDBMapper uses default SaveBehavior with AttributeEncryptor, risking inconsistent encryption and potential security issues.
    public void nonCompliant() {
        DynamoDBMapperConfig config = DynamoDBMapperConfig.builder().build();
        DynamoDBMapper mapper = new DynamoDBMapper(ddb, config, attributeEncryptor);
    }
}
// {/fact}
