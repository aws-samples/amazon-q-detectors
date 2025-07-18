<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-session-fixation@v1.0 defects=1}
class SecurityConfig 
{
    public function nonCompliant() 
    {
        // Noncompliant: Setting `SESSION_FIXATION_STRATEGY` to 'none' allows session fixation attacks.
        $container->loadFromExtension('security', array('SESSION_FIXATION_STRATEGY' => 'NONE'));
    }
}
// {/fact}
?>
