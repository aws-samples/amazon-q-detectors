// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-xml-injection@v1.0 defects=0}
using System;
using System.Security;
using System.Web;
using System.Xml;

namespace SecureXMLHandling
{
    public class ConformantXMLHandler : IHttpHandler
    {
        public void ProcessRequest(HttpContext ctx)
        {
            string employeeName = ctx.Request.QueryString["name"];

            using (XmlWriter writer = XmlWriter.Create("employees.xml"))
            {
                writer.WriteStartDocument();
                writer.WriteStartElement("employee");

                // Compliant: Using `SecurityElement.Escape` to sanitize user input before writing to XML.
                writer.WriteElementString("name", SecurityElement.Escape(employeeName));

                writer.WriteEndElement();
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