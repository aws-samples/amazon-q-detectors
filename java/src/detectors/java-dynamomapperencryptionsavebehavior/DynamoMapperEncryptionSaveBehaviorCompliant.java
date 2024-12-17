// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-dynamomapperencryptionsavebehavior@v1.0 defects=0}
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DynamoMapperEncryptionSaveBehaviorCompliant {

    Region region = Region.getRegion(Regions.US_WEST_2);
    AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.standard().withRegion(String.valueOf(region)).build();

    // Compliant: DynamoDBMapper uses custom SaveBehavior, ensuring proper handling of attributes during save operations.
    public void compliant() {
        DynamoDBMapperConfig config = DynamoDBMapperConfig.builder().withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.UPDATE_SKIP_NULL_ATTRIBUTES).build();
        DynamoDBMapper mapper = new DynamoDBMapper(ddb,config);
    }
}
// {/fact}
