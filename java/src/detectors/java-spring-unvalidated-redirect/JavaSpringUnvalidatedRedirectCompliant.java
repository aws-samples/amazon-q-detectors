// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-spring-unvalidated-redirect@v1.0 defects=0}
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class SpringUnvalidatedRedirect_Conformant {

    @RequestMapping(value = "/conformingRedirect", method = RequestMethod.GET)
    // Compliant: Uses a hardcoded redirect URL that cannot be manipulated by user input, preventing open redirect vulnerabilities.
    public String conformant() {
        return getConformingRedirectUrl();
    }

    private String getConformingRedirectUrl() {
        return "redirect:/";
    }
}
// {/fact}
