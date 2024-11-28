// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-log-injection@v1.0 defects=0}
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class LogInjectionCompliant {

    // Compliant: Input is sanitized before logging.
    @RequestMapping("/example.htm")
    public ModelAndView loggingCompliant(HttpServletRequest request) {
        ModelAndView result = new ModelAndView("success");
        String userId = request.getParameter("userId");
        String sanitizedUserId = sanitize(userId);
        result.addObject("userId", sanitizedUserId);
        log.info("Successfully processed request for user ID: {}.", sanitizedUserId);
        return result;
    }

    private static String sanitize(String userId) {
        return userId.replaceAll("\\D", "");
    }
}
// {/fact}
