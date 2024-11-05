<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

//{fact rule=php-symfony-permissive-cors@v1.0 defects=1}
// Noncompliant: Sets `access-control-allow-origin` header to `*`, allowing unrestricted cross-origin access and potentially exposing sensitive data.
namespace Symfony;
use Symfony\Component\HttpFoundation\Response;
$response = new Response('context', Response::HTTP_OK, ['access-control-allow-origin' => '*']);
//{/fact}
?>
