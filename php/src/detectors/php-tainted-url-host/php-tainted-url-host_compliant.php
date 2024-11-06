<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

//{fact rule=php-tainted-url-host@v1.0 defects=0}
function makeRequest($url) {
    $ch = curl_init($url);
    curl_setopt($ch, CURLOPT_HEADER, 0);
    $data = curl_exec($ch);
    curl_close($ch);
    return $data;
}
function compliant() {
    // Compliant: Sanitizes user input with `htmlspecialchars()` before using it in URL construction, preventing potential URL manipulation attacks.
    $url = 'https://www.google.com/' . htmlspecialchars($_POST['url'], ENT_QUOTES, 'UTF-8') . '/foobar';
    $info = makeRequest($url);
    return $info;
}
//{/fact}
?>
