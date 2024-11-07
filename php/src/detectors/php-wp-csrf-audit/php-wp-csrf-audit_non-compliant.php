<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

//{fact rule=php-wp-csrf-audit@v1.0 defects=1}
// Noncompliant: Uses `check_ajax_referer()` with die parameter set to `0`, allowing the request to continue even if the nonce check fails.
check_ajax_referer( 'wpforms-admin', 'nonce', 0 );
//{/fact}
?>