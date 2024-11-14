<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-insecure-socket-usage@v1.0 defects=0}
// Compliant: Enables peer verification for SSL connections, enhancing security by validating the authenticity of the remote server.
$secureContext = stream_context_create([
  'ssl' => [
    'verify_peer' => true,
  ],
]);
// {/fact}
?>
