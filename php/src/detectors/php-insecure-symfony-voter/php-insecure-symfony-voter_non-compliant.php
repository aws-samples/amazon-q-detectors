<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-insecure-symfony-voter@v1.0 defects=1}
use Symfony\Component\Security\Core\Authorization\Voter\Voter;
use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;

class cases extends Voter
{
    public function nonCompliant(string $attribute, $subject, TokenInterface $token)
    {
        if ('EDIT' === $attribute) {
            // Noncompliant: Returning boolean instead of Voter constants.
            return true;
        }
        
        return false;
    }
}
// {/fact}
?>
