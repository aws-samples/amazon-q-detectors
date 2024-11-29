// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-log-injection@v1.0 defects=1}
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class LogInjectionNoncompliant {

    // Noncompliant: Unsanitized input is logged.
    @RequestMapping("/example.htm")
    public ModelAndView loggingNonCompliant(HttpServletRequest request) {
        ModelAndView result = new ModelAndView("success");
        String userId = request.getParameter("userId");
        result.addObject("userId", userId);
        log.info("Successfully processed request for user ID: {}.", userId);
        return result;
    }
}
// {/fact}
