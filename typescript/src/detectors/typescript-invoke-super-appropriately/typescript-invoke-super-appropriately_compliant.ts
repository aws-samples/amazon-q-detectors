// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-invoke-super-appropriately@v1.0 defects=0}
class Animal {
    doSomething(): void {
        console.log("Animal is doing something");
    }
}

class Dog extends Animal {
    name: string;

    constructor(name: string) {
        // Compliant: `super()` is being invoked appropriately.
        super();
        this.name = name;
        super.doSomething();
    }
}
// {/fact}