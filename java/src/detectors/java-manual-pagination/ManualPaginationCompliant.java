// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-manual-pagination@v1.0 defects=0}
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
import software.amazon.awssdk.services.s3.model.S3Object;
import java.util.ArrayList;
import java.util.List;

public class ManualPaginationCompliant {

    // Compliant: Below Method uses Auto-Pagination Api.
    public static List<S3Object> compliant(ListObjectsV2Request request) {
        List<S3Object> objects = new ArrayList<>();
        try (S3Client s3Client = S3Client.create()) {
            for (ListObjectsV2Response response : s3Client.listObjectsV2Paginator(request)) {
                objects.addAll(response.contents());
            }
        }
        return objects;
    }
}
// {/fact}
