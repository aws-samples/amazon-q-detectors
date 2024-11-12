// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-insecure-hex-value@v1.0 defects=0}

import java.security.SecureRandom;

public class InsecureHexValueCompliant{
    // Compliant: String.format used with "%02X" to generate a secure, properly formatted hexadecimal representation.
    public void compliant() {
        String basic = getClass().getName();
        basic = basic.substring(basic.lastIndexOf('.')+1);
        StringBuffer buffer = new StringBuffer(basic);
        SecureRandom secureRandom = new SecureRandom();
        int randomValue = secureRandom.nextInt(256);
        buffer.append('@').append(String.format("%02X", randomValue));
    }
}
// {/fact}

