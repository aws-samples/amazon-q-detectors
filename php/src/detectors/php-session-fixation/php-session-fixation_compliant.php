<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-session-fixation@v1.0 defects=0}
class SecurityConfig 
{
    public function compliant() 
    {
        // Compliant: Session fixation is mitigated by regenerating the session ID on authentication.
        $container->loadFromExtension('security', array('SESSION_FIXATION_STRATEGY' => 'migrate'));
    }

}
// {/fact}
?>
