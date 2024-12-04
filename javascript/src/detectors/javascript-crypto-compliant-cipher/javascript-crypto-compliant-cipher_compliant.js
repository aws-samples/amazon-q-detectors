// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-crypto-compliant-cipher@v1.0 defects=0}
var crypto = require("crypto");

function compliant(){
    const key = crypto.randomBytes(24);
    const iv = crypto.randomBytes(12);

    // Compliant: Usage of `aes` with `gcm`, which is a secure cipher algorithm.
    const cipher = crypto.createCipheriv("aes-192-gcm", key, iv);

    const plaintext = "Hello world";

    const aad = Buffer.from("additional authenticated data", "utf8");

    cipher.setAAD(aad, {
        plaintextLength: Buffer.byteLength(plaintext)
    });

    let ciphertext = cipher.update(plaintext, "utf8", "hex");
    ciphertext += cipher.final("hex");

    const tag = cipher.getAuthTag();

    console.log("Ciphertext:", ciphertext);
    console.log("Auth Tag:", tag.toString("hex"));
}
// {/fact}
