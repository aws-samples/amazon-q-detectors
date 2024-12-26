// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-spring-unvalidated-redirect@v1.0 defects=0}
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RedirectController {

    private enum RedirectDestination {
        HOME("/home"),
        DASHBOARD("/dashboard"),
        PROFILE("/profile");

        private final String url;

        RedirectDestination(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }
    }

    @GetMapping("/compliant")
    public String compliant(@RequestParam(name = "destination", required = false) String destination) {

        String redirectDestination;
        try {
            // Compliant: User input is validated against a known list of values before using it in a redirect.
            RedirectDestination redirectDestinationEnum = RedirectDestination.valueOf(destination.toUpperCase(Locale.US));
            redirectDestination = redirectDestinationEnum.getUrl();
        } catch (IllegalArgumentException | NullPointerException e) {
            redirectDestination = "/error";
        }

        return "redirect:" + redirectDestination;
    }
}
// {/fact}
