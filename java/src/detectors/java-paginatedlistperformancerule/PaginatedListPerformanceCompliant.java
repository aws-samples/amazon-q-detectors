// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-paginatedlistperformancerule@v1.0 defects=0}
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.iotfleethub.model.ApplicationState;

public class PaginatedListPerformanceCompliant {
    private static DynamoDBMapper mapper;

    // Compliant: Uses `isEmpty()` and `get(0)` instead of `size()` on `PaginatedQueryList`, avoiding unnecessary DynamoDB queries.
    public ApplicationState getLatestAppForAccount(String accountId) {
        DynamoDBQueryExpression recentAppsQuery = new DynamoDBQueryExpression<ApplicationState>()
                .withIndexName("1")
                .withLimit(1)
                .withScanIndexForward(false)
                .withConsistentRead(false);
        PaginatedQueryList<ApplicationState> latestAppResult = mapper.query(ApplicationState.class, recentAppsQuery);
        if (latestAppResult != null && !latestAppResult.isEmpty()) {
            return latestAppResult.get(0);
        }
        return null;
    }
}
// {/fact}
