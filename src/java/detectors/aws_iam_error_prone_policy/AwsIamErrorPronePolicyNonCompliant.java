// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-handcrafted-policies@v1.0 defects=1}
import com.amazonaws.regions.Regions;
import com.amazonaws.services.identitymanagement.AmazonIdentityManagement;
import com.amazonaws.services.identitymanagement.AmazonIdentityManagementClientBuilder;
import com.amazonaws.services.identitymanagement.model.CreateRoleRequest;

public class AwsIamErrorPronePolicyNonCompliant {

    // NonCompliant: IAM policy is manually crafted as a string, risking errors and security vulnerabilities.
    public void nonCompliant(final String roleName, String userArn) {
        final AmazonIdentityManagement iamClient = AmazonIdentityManagementClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
        String policyDocument = "{\n" +
                " \"Version\": \"2012-10-17\",\n" +
                "  \"Statement\": [\n" +
                "   {\n" +
                "      \"Effect\": \"Allow\",\n" +
                "      \"Principal\": {\n" +
                "        \"AWS\": \"" + userArn + "\"\n" +
                "      },\n" +
                "      \"Action\": \"sts:AssumeRole\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        final CreateRoleRequest createRoleRequest = new CreateRoleRequest();
        createRoleRequest.withPath("path").withRoleName(roleName).withAssumeRolePolicyDocument(policyDocument);
        iamClient.createRole(createRoleRequest);
    }
}
// {/fact}
