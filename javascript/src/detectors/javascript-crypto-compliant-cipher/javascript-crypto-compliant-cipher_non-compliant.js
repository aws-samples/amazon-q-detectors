// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-crypto-compliant-cipher@v1.0 defects=1}
var crypto = require("crypto");

function nonCompliant(){
	const key =  crypto.randomBytes(24);
	const iv =  crypto.randomBytes(24);

    // Noncompliant: Usage of `des` , which is not a secure cipher algorithm.
	const cipher = crypto.createCipheriv("DES", key, iv);
	
	const plaintext = "Hello world";

	const aad = Buffer.from("00112233445566778899aabbccddeeff", "hex");

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
