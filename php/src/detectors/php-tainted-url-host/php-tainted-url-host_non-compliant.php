<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-tainted-url-host@v1.0 defects=1}
function makeRequest($url) {
    $ch = curl_init($url);
    curl_setopt($ch, CURLOPT_HEADER, 0);
    $data = curl_exec($ch);
    curl_close($ch);
    return $data;
}
function nonCompliant() {
    // Noncompliant: Uses unsanitized user input directly in URL construction, potentially allowing URL manipulation and SSRF attacks.
    $url = 'https://' . $_POST['url'] . '/foobar'; 
    $info = makeRequest($url);
    return $info;
}
// {/fact}
?>
