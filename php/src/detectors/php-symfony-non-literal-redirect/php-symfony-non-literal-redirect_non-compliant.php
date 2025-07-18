<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-symfony-non-literal-redirect@v1.0 defects=1}
use Symfony\Component\HttpFoundation\RedirectResponse;
class WebAppController
{
    public function nonCompliant(): RedirectResponse
    {
        $foo = $session->get('foo');
        // Noncompliant: Uses `redirect()` with unvalidated user input, potentially allowing open redirect vulnerabilities.
        return $this->redirect($foo);
    }
}
// {/fact}
?>
