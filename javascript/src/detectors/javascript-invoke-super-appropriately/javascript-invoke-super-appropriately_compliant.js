// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-invoke-super-appropriately@v1.0 defects=0}
class Animal{
}

class Dog extends Animal {
    constructor(name) {
        // Compliant: `super()` is being invoked appropriately.
        super();
        this.name = name;
    }
}
// {/fact}
