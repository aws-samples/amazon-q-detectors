// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-batch-write-output-ignored@v1.0 defects=0}
import * as AWS from 'aws-sdk';

interface JobFilter {
    nextToken?: string;
    [key: string]: any;
}

interface Logger {
    debug: (message: string) => void;
}

async function compliant(filter: JobFilter): Promise<AWS.Batch.JobSummaryList> {
    const batchClient: AWS.Batch = new AWS.Batch();
    const logger: Logger = console as Logger;
    
    try {
        let jobsList: AWS.Batch.JobSummaryList = [];

        do {
            const response: AWS.Request<AWS.Batch.ListJobsResponse, AWS.AWSError> = 
                batchClient.listJobs(filter);
            
            const data: AWS.Batch.ListJobsResponse = await response.promise();
            
            if (data.jobSummaryList) {
                jobsList = jobsList.concat(data.jobSummaryList);
            }
            
            filter.nextToken = data.nextToken;
            
            response.promise()
                .then((data: AWS.Batch.ListJobsResponse) => {
                    console.log('Success');
                })
                .catch((err: AWS.AWSError) => {
                    console.log(err);
                });
                
        } while (filter.nextToken)
        
        // Compliant: Properly handles batch operation responses, ensuring errors are logged and results are processed.
        return jobsList;

    } catch (error) {
        if (error instanceof Error) {
            logger.debug(`getJobs failed: ${error.stack}`);
        } else {
            logger.debug('getJobs failed with unknown error');
        }
        throw error;
    }
}
// {/fact}
