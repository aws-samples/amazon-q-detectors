// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-awsserviceclientinitialization@v1.0 defects=0}
import com.amazonaws.regions.Regions;
import com.amazonaws.services.datapipeline.DataPipeline;
import com.amazonaws.services.datapipeline.DataPipelineAsyncClientBuilder;

public class AwsServiceClientInitializationCompliant {
    public void compliant(){
        DataPipeline client = DataPipelineAsyncClientBuilder.standard()
            // Compliant: Specifying the region explicitly using `withRegion()` helps prevents to poor cold-start performance.
            .withRegion(Regions.US_WEST_2)
            .build();
    }
}
// {/fact}
