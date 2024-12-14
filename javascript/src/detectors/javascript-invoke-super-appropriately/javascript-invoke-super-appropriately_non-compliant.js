// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-invoke-super-appropriately@v1.0 defects=1}
class Animal{
}

class Dog extends Animal {
    constructor(name) {
        super();
        this.name = name;
        // Noncompliant:  Calling `super()` multiple times will result in a type error.
        super();
        super();
    }
}
// {/fact}
