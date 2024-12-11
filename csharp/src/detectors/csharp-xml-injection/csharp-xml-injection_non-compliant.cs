// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-xml-injection@v1.0 defects=1}
using System;
using System.Web;
using System.Xml;

namespace InsecureXMLHandling
{
    public class NonConformantXMLHandler : IHttpHandler
    {
        public void ProcessRequest(HttpContext ctx)
        {
            string employeeName = ctx.Request.QueryString["name"];

            using (XmlWriter writer = XmlWriter.Create("employees.xml"))
            {
                writer.WriteStartDocument();

                // Noncompliant: Directly writing unsanitised user input to XML, vulnerable to XML injection.
                writer.WriteRaw("<employee><name>" + employeeName + "</name></employee>");

                writer.WriteEndDocument();
            }

            ctx.Response.ContentType = "text/plain";
            ctx.Response.Write("Employee added successfully.");
        }

        public bool IsReusable
        {
            get { return false; }
        }
    }
}
//{/fact}