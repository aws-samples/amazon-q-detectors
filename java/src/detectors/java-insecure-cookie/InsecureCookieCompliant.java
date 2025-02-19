// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-insecure-cookie@v1.0 defects=0}
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.openqa.selenium.WebDriver;
public class InsecureCookieCompliant {

    public void compliant(HttpServletResponse res) {
        HttpCookie c = new HttpCookie("name", "not-null");
        // Compliant: Secure cookie settings can helps prevent to cookie theft and unauthorized access to user accounts or sensitive data.
        c.setHttpOnly(true); c.setSecure(true);
        res.addCookie(c);
  }
}
// {/fact}
