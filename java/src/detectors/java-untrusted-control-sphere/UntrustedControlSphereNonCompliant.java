/*
* Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
* SPDX-License-Identifier: MIT-0
*/

// {fact rule=java-untrusted-control-sphere@v1.0 defects=1}
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ServiceLoader;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UntrustedControlSphereNonCompliant {

    public void nonCompliant(HttpServletRequest request) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String className = request.getParameter("className");
        String codebase = request.getParameter("codebase");

        if (className == null || codebase == null) {
            throw new IllegalArgumentException("className and codebase parameters cannot be null");
        }
        
        URL[] urls = new URL[]{new URL(codebase)};
        URLClassLoader loader = null;
        try {
            loader = new URLClassLoader(urls);
            // Noncompliant: Loading classes from user-controlled location allows attackers to supply malicious code.
            Class<?> loadedClass = loader.loadClass(className);
            Object instance = loadedClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load class", e);
        } finally {
            if (loader != null) {
                try {
                    loader.close();
                } catch (IOException e) {
                    log.error("Failed to close URLClassLoader", e);
                }
            }
        }
    }
}
// {/fact}
