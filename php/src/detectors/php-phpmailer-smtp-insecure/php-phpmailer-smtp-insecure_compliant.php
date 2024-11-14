<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-phpmailer-smtp-insecure@v1.0 defects=0}
use PHPMailer\PHPMailer\PHPMailer;
$secureMailClient = new PHPMailer(true);
// Compliant: Uses SSL encryption for SMTP communication by specifying `ssl://` in the host address, ensuring secure data transmission.
$secureMailClient->Host = 'ssl://secure-mail.com';
// {/fact}
?>
