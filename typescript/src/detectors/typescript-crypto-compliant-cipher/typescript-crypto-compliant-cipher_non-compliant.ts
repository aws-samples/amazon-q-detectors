// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-crypto-compliant-cipher@v1.0 defects=1}
import * as crypto from 'crypto';

function nonCompliant(): void {
    const key: Buffer = crypto.randomBytes(24);
    const iv: Buffer = crypto.randomBytes(24);

    // Noncompliant: Usage of `des`, which is not a secure cipher algorithm.
    const cipher: crypto.Cipher = crypto.createCipheriv("DES", key, iv);
    
    const plaintext: string = "Hello world";

    const aad: Buffer = Buffer.from("00112233445566778899aabbccddeeff", "hex");

    cipher.setAAD(aad, {
        plaintextLength: Buffer.byteLength(plaintext)
    });

    let ciphertext: string = cipher.update(plaintext, "utf8", "hex");
    ciphertext += cipher.final("hex");

    const tag: Buffer = cipher.getAuthTag();

    console.log("Ciphertext:", ciphertext);
    console.log("Auth Tag:", tag.toString("hex"));
}

// {/fact}
