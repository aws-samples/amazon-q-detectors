// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-sql-injection-in-aws-query-services@v1.0 defect=1}
import com.amazonaws.services.athena.AmazonAthenaClient;
import com.amazonaws.services.athena.model.StartQueryExecutionRequest;
import com.amazonaws.services.athena.model.StartQueryExecutionResult;
import com.amazonaws.services.athena.model.ResultConfiguration;
import com.amazonaws.services.athena.model.QueryExecutionContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SQLInjectionInAWSQueryServicesNonCompliant {
    private AmazonAthenaClient amazonAthena;

    // NonCompliant: Direct string concatenation in query
    public void nonCompliant(HttpServletRequest httpServletRequest,
                             String fileId,
                             HttpServletResponse httpServletResponse) {
        String query = "SELECT * FROM TABLE WHERE var = '" + fileId + "'";
        StartQueryExecutionRequest startQueryExecutionRequest = new StartQueryExecutionRequest()
                .withQueryString(query)
                .withQueryExecutionContext(new QueryExecutionContext().withDatabase("database"))
                .withResultConfiguration(new ResultConfiguration()
                        .withOutputLocation("s3://output-location/"));
        StartQueryExecutionResult startQueryExecutionResult = amazonAthena.startQueryExecution(startQueryExecutionRequest);
    }
}
// {/fact}