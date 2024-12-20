// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-polling-to-waiters@v1.0 defects=0}
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.*;
import com.amazonaws.waiters.*;
import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class PollingToWaitersCompliant {

    // Compliant: Uses AWS SDK waiters for efficient and standardized instance state checking.
    public void compliant(final String instanceId, final AmazonEC2 ec2Client)
            throws InterruptedException {
        Waiter<DescribeInstancesRequest> waiter = ec2Client.waiters().instanceTerminated();
        ec2Client.terminateInstances(new TerminateInstancesRequest().withInstanceIds(instanceId));
        try {
            waiter.run(new WaiterParameters()
                    .withRequest(new DescribeInstancesRequest().withInstanceIds(instanceId))
                    .withPollingStrategy(new PollingStrategy(new MaxAttemptsRetryStrategy(60),
                            new FixedDelayStrategy(5))));

        } catch (WaiterTimedOutException e) {
            List<InstanceStatus> instanceStatusList = ec2Client.describeInstanceStatus(
                            new DescribeInstanceStatusRequest()
                                    .withInstanceIds(instanceId)
                                    .withIncludeAllInstances(true))
                    .getInstanceStatuses();
            String state;
            if (instanceStatusList != null && instanceStatusList.size() > 0) {
                state = instanceStatusList.get(0).getInstanceState().getName();
                if (!Arrays.asList(InstanceStateName.ShuttingDown.toString(),
                        InstanceStateName.Terminated.toString()).contains(state)) {
                    log.error("WaiterTimedOutException: " + e);
                }
            }
        }
    }
}
// {/fact}
