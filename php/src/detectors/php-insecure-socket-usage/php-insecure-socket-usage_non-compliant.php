<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

//{fact rule=php-insecure-socket-usage@v1.0 defects=1}
// Noncompliant: Creates a pair of connected, non-encrypted sockets, potentially exposing sensitive data to interception.
$socketPair = stream_socket_pair($domain, $socketType, $socketProtocol);
//{/fact}
?>
