<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-symfony-non-literal-redirect@v1.0 defects=0}
use Symfony\Component\HttpFoundation\RedirectResponse;
class WebAppController
{
    public function compliant(): RedirectResponse
    {
        $foo = $session->get('foo');
        // Compliant: Uses `redirectToRoute()` method, which internally validates and constructs the URL, mitigating risks associated with open redirects.
        return $this->redirectToRoute($foo);
    }
}
// {/fact}
?>
