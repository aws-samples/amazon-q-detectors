// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-code-injection@v1.0 defects=1}
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CodeInjectionNonCompliant {

    public void responseSendError(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ScriptException {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        // Noncompliant: Running scripts from unsanitized inputs allows remote code execution.
        engine.eval(request.getParameter("page"));
    }
}
// {/fact}
