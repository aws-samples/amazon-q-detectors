// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-code-injection@v1.0 defects=0}
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CodeInjectionCompliant {

    public void compliant(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ScriptException {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        // Compliant: Validating user-provided data before using it helps prevent to injection attacks.
        if (!request.getParameter("page").matches("SAFE_CODE_PATTERN"))
            throw new IllegalArgumentException("Input does not match allowlisted pattern.");
        engine.eval( request.getParameter("page"));
    }
}
// {/fact}
