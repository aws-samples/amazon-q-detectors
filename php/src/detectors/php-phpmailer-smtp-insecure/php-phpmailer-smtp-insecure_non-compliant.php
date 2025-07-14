<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-phpmailer-smtp-insecure@v1.0 defects=1}
use PHPMailer\PHPMailer\PHPMailer;
$vulnerableMailClient = new PHPMailer(true);
// Noncompliant: Sets `SMTPSecure` to an empty string, disabling encryption for SMTP communication and exposing email data to potential interception.
$vulnerableMailClient->Host = 'vulnerable-host.com';
$vulnerableMailClient->SMTPSecure = '';
// {/fact}
?>
