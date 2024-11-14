<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-symfony-permissive-cors@v1.0 defects=0}
namespace Symfony;
use Symfony\Component\HttpFoundation\Response;
$safeHeaders = ['foo' => 'bar'];
// Compliant: Uses predefined safe headers instead of allowing all origins, preventing overly permissive CORS settings.
$response = new Response('context', Response::HTTP_OK, $safeHeaders);
// {/fact}
?>