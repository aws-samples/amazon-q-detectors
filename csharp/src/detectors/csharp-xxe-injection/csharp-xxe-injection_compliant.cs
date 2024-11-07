// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-xxe-injection@v1.0 defects=0}
using System;
using System.IO;
using System.Xml;

namespace XXEInjection.Compliant
{
    public class XmlExternalEntity
    {
        public void XmlExternalEntityCompliant(string str)
        {
            XmlReaderSettings readersetting = new XmlReaderSettings();
            // Compliant: `DtdProcessing.Ignore` disables DTD processing, preventing XXE vulnerabilities.
            readersetting.DtdProcessing = DtdProcessing.Ignore;
            XmlReader reader = XmlReader.Create(new StringReader(str), readersetting);
            
            while (reader.Read())
            {
                Console.WriteLine(reader.Value);
            }
        }
        static void Main(string[] args)
        {
            string xmlInput = @"<?xml version=""1.0""?><!DOCTYPE root [<!ENTITY test SYSTEM ""file:///etc/passwd"">]><root>&test;</root>";
            var xml = new XmlExternalEntity();
            xml.XmlExternalEntityCompliant(xmlInput);
        }
    }
}
 // {/fact}