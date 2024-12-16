// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-polling-to-waiters@v1.0 defects=1}
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;
import com.amazonaws.services.ec2.model.Instance;
import lombok.extern.slf4j.Slf4j;
import java.time.Duration;
import java.util.List;

@Slf4j
public class PollingToWaitersNoncompliant {

    // Noncompliant: Uses manual polling instead of AWS SDK waiters for checking instance state.
    private void nonCompliant(AmazonEC2 ec2, List<Instance> terminatedInstances) {
        long expirationTime = System.currentTimeMillis() + Duration.ofMinutes(1).toMillis();
        try {
            for(Instance instance: terminatedInstances) {
                while(System.currentTimeMillis() < expirationTime && ! instance.getState().getName().equals("terminated")) {
                    log.info("waiting for " + instance.getInstanceId() + " " + instance.getState().getName());
                    Thread.sleep(5000);
                    instance = ec2.describeInstances(
                                    new DescribeInstancesRequest().withInstanceIds(instance.getInstanceId()))
                            .getReservations().get(0).getInstances().get(0);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
// {/fact}
