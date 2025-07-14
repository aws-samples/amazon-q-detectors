<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-hardcoded-credentials-libs-ide@v1.0 defects=1}

use Aws\S3\S3Client;
use GuzzleHttp\Client;

class AWSService {
    public function createS3Client() {
        // Noncompliant: Hardcoded AWS credentials.
        $s3 = new S3Client([
            'version' => 'latest',
            'region' => 'us-east-1',
            'credentials' => [
                'key' => 'AKIAIOSFODNN7EXAMPLE',
                'secret' => 'wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY'
            ]
        ]);
        return $s3;
    }
}
// {/fact}
?>
