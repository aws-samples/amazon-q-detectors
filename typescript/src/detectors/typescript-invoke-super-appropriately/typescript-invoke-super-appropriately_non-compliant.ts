// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-invoke-super-appropriately@v1.0 defects=1}
class Animal {
}

class Dog extends Animal {
    name: string;

    constructor(name: string) {
        // Noncompliant: `super()` is being invoked inappropriately.
        super();
        this.name = name;
        super();
        super.doSomething();
        super();
    }
}
// {/fact}
