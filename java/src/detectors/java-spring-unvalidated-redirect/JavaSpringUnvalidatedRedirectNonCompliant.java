// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-spring-unvalidated-redirect@v1.0 defects=1}
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
class SpringUnvalidatedRedirect_NonCompliant {

    String strRedirectUrl;

    @RequestMapping(value = "/redirect1", method = RequestMethod.GET)
    // Noncompliant: Directly uses unvalidated user input for redirection, which could allow attackers to redirect users to malicious websites through URL parameter manipulation.
    public String redirect1(@RequestParam("url") String url) {
        return "redirect:" + url;
    }
}
// {/fact}
