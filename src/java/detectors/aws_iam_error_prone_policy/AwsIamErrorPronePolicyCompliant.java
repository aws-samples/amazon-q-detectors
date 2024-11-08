// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-handcrafted-policies@v1.0 defects=0}
import com.amazonaws.regions.Regions;
import com.amazonaws.services.identitymanagement.AmazonIdentityManagement;
import com.amazonaws.services.identitymanagement.AmazonIdentityManagementClientBuilder;
import com.amazonaws.services.identitymanagement.model.CreateRoleRequest;
import com.amazonaws.services.identitymanagement.model.GetRolePolicyRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class AwsIamErrorPronePolicyCompliant {

    // Compliant: IAM policy is retrieved from existing role, avoiding manual crafting and potential errors.
    public void compliant(final String roleName) throws UnsupportedEncodingException {
        final AmazonIdentityManagement iamClient = AmazonIdentityManagementClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
        final String policyDocument = URLDecoder.decode(iamClient.getRolePolicy(new GetRolePolicyRequest()).getPolicyDocument(), "UTF-8");
        final CreateRoleRequest createRoleRequest = new CreateRoleRequest()
                .withRoleName(roleName)
                .withAssumeRolePolicyDocument(policyDocument);
        final String policyArn = iamClient.createRole(createRoleRequest).getRole().getArn();
    }
}
// {/fact}