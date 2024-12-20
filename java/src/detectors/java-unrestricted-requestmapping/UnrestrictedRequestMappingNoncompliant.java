// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-unrestricted-requestmapping@v1.0 defects=1}

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
public class UnrestrictedRequestMappingNoncompliant {

    // Noncompliant: Uses @RequestMapping without specifying HTTP method, potentially allowing unintended access through any HTTP method.
    @RequestMapping(value = "/test")
    public String nonCompliant() {
        return "Nothing";
    }
}
// {/fact}
