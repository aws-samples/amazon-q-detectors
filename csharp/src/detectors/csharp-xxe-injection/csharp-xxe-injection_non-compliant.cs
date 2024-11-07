// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-xxe-injection@v1.0 defects=1}
using System;
using System.IO;
using System.Xml;

namespace XXEInjection.NonCompliant
{
    public class XmlExternalEntity
    {
        public void XmlExternalEntityNoncompliant(string str)
        {
            XmlReaderSettings readersetting = new XmlReaderSettings();
            // Noncompliant: Enabling `DtdProcessing.Parse` allows processing of external entities, potentially leading to XXE vulnerabilities.
            readersetting.DtdProcessing = DtdProcessing.Parse;
            XmlReader reader = XmlReader.Create(new StringReader(str), readersetting);
            
            while (reader.Read())
            {
                Console.WriteLine(reader.Value);
            }
        }
    }
}
// {/fact}