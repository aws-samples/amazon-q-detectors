// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-sql-injection-in-aws-query-services@v1.0 defect=0}
import com.amazonaws.services.athena.model.StartQueryExecutionRequest;
import com.amazonaws.services.athena.model.StartQueryExecutionResult;
import com.amazonaws.services.athena.model.ResultConfiguration;
import com.amazonaws.services.athena.model.QueryExecutionContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SQLInjectionInAWSQueryServicesCompliant {
    // Compliant: Prevent SQL injection with safer query construction
    public void compliant(HttpServletRequest httpServletRequest,
                          HttpServletResponse httpServletResponse) {
        QueryExecutionContext queryContext = new QueryExecutionContext()
                .withDatabase("your_database_name");
        String queryString = "SELECT * FROM TABLE WHERE var = A";

        StartQueryExecutionRequest startQueryExecutionRequest = new StartQueryExecutionRequest()
                .withQueryString(queryString)
                .withQueryExecutionContext(queryContext)
                .withResultConfiguration(new ResultConfiguration()
                        .withOutputLocation("s3://your-output-location/"));

    }
}
// {/fact}