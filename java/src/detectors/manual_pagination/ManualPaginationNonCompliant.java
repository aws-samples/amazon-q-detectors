// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-manual-pagination@v1.0 defects=1}
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;
import java.util.ArrayList;
import java.util.List;

public class ManualPaginationNonCompliant {

    // Noncompliant: Below Method uses Manual pagination.
    public static List<ListObjectsV2Response> nonCompliant(ListObjectsV2Request request) {
        List<ListObjectsV2Response> responses = new ArrayList<>();
        try (S3Client s3Client = S3Client.create()) {
            ListObjectsV2Response response = s3Client.listObjectsV2(request);
            responses.add(response);
            while (response.isTruncated()) {
                String nextContinuationToken = response.nextContinuationToken();
                request = ListObjectsV2Request.builder()
                        .bucket(request.bucket())
                        .prefix(request.prefix())
                        .continuationToken(nextContinuationToken)
                        .build();
                response = s3Client.listObjectsV2(request);
                responses.add(response);
            }
        }
        return responses;
    }
}
// {/fact}
