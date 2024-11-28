// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-weak-password-encoder@v1.0 defect=1}
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
public class WeakPasswordEncoderJavaRuleNonCompliant {
    // NonCompliant : Weak password encoder is used.
    public void nonCompliant(String password) {
        PasswordEncoder passwordEncoder = new LdapShaPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
    }
}
// {/fact}