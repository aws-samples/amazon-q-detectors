// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-insecure-hex-value@v1.0 defect=1}

import java.security.SecureRandom;

public class InsecureHexValueNonCompliant{

    // NonCompliant: Integer.toHexString used, potentially leading to predictable hex representations.
    public void nonCompliant() {
        String basic = getClass().getName();
        basic = basic.substring(basic.lastIndexOf('.')+1);
        StringBuffer buffer = new StringBuffer(basic);
        SecureRandom secureRandom = new SecureRandom();
        int randomValue = secureRandom.nextInt(256);
        buffer.append('@').append(Integer.toHexString(randomValue));
    }
}
// {/fact}

