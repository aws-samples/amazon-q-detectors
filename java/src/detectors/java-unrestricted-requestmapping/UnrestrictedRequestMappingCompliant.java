// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-unrestricted-requestmapping@v1.0 defects=0}
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Slf4j
public class UnrestrictedRequestMappingCompliant {

    // Compliant: Uses @RequestMapping with a specific HTTP method (GET), restricting access to the intended HTTP method only.
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String compliant() {
        return "Nothing";
    }
}
// {/fact}
