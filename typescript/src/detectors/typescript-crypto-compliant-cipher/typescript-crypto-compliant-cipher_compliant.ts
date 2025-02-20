// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-crypto-compliant-cipher@v1.0 defects=0}
import * as crypto from 'crypto';

function compliant(): void {
    const key: Buffer = crypto.randomBytes(24);
    const iv: Buffer = crypto.randomBytes(12);

    // Compliant: Usage of `aes` with `gcm`, which is a secure cipher algorithm.
    const cipher: crypto.CipherGCM = crypto.createCipheriv('aes-192-gcm', key, iv);

    const plaintext: string = "Hello world";

    const aad: Buffer = Buffer.from("additional authenticated data", "utf8");

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
