<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-hardcoded-credentials-libs-ide@v1.0 defects=0}

use Aws\S3\S3Client;
use GuzzleHttp\Client;

class AWSService {
    public function createS3Client() {
        // Compliant: Using environment variables for AWS credentials.
        $s3 = new S3Client([
            'version' => 'latest',
            'region' => $_ENV['AWS_REGION'] ?? 'us-east-1',
            'credentials' => [
                'key' => $_ENV['AWS_ACCESS_KEY_ID'],
                'secret' => $_ENV['AWS_SECRET_ACCESS_KEY']
            ]
        ]);
        return $s3;
    }
}
// {/fact}
?>
