// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-improper-authentication@v1.0 defects=0}
#include <iostream>
#include <string>
#include <jwt-cpp/jwt.h>

void compliant() {
    std::string secret = "your_secret_key";

    std::string correctToken = jwt::create()
                                .set_issuer("your_issuer")
                                .set_type("JWT")
                                .set_payload_claim("user_id", jwt::claim(std::string("123")))
                                .sign(jwt::algorithm::hs256{ secret });

    std::cout << "Generated Token: " << correctToken << std::endl;

    
    std::string inCorrectToken = "invalid_token";

    try {
        
        // Compliant: Signature verification has been ensured below.
        auto decoded_token = jwt::decode(inCorrectToken, 
                                         jwt::algorithms({ jwt::algorithm::hs256{ secret } }), 
                                         true);

        std::cout << "Decoded token: " << decoded_token.payload() << std::endl;
    } catch (const std::exception& e) {
        std::cerr << "Error decoding or verifying token: " << e.what() << std::endl;
    }
}
// {/fact}
