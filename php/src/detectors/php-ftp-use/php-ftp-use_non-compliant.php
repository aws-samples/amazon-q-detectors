<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-ftp-use@v1.0 defects=1}
// Noncompliant: Used insecure FTP functions that transmit credentials in plain text, such as `ftp_login`.
$ftpLoginResult = ftp_login($ftpConnection, $ftpUsername, $ftpPassword);
// {/fact}
?>
