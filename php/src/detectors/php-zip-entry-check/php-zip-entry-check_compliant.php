<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-zip-entry-check@v1.0 defects=0}
// Compliant: `zipEntryRead` will read the next `1024` bytes of data from the zip entry starting from the current position.
zipEntryRead($zip_entry, 1024); 
// {/fact}
?>
