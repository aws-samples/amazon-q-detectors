/*
* Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
* SPDX-License-Identifier: MIT-0
*/

// {fact rule=java-untrusted-control-sphere@v1.0 defects=0}
import java.net.URL;
import java.net.MalformedURLException;
import java.net.URLClassLoader;
import java.util.ServiceLoader;
import javax.servlet.http.HttpServletRequest;

public class UntrustedControlSphereCompliant {
    
    public void compliant() throws MalformedURLException {
        URL trustedUrl = new URL("https://trusted-plugins.example.com/plugins/");
        try (URLClassLoader loader = new URLClassLoader(new URL[]{trustedUrl})) {
            // Compliant: Loading plugins only from trusted URL prevents execution of malicious plugins.
            ServiceLoader<Plugin> serviceLoader = ServiceLoader.load(Plugin.class, loader);
            for (Plugin plugin : serviceLoader) {
                plugin.execute();
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load plugins", e);
        }
    }
}
// {/fact}
