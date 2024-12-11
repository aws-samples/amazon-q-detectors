// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-xpath-injection@v1.0 defects=0}
using System;
using System.Collections.Generic;
using System.Xml;
using System.Xml.XPath;
using Microsoft.AspNetCore.Hosting;

namespace XPathSearchExample
{
    public class ConformantXPathSearch
    {
        private readonly IWebHostEnvironment _env;

        public ConformantXPathSearch(IWebHostEnvironment env)
        {
            _env = env;
        }

        public List<Knowledge> Search(string input)
        {
            List<Knowledge> searchResult = new List<Knowledge>();
            var webRoot = _env.WebRootPath;
            var file = System.IO.Path.Combine(webRoot, "Knowledgebase.xml");

            XmlDocument xmlDoc = new XmlDocument();
            xmlDoc.Load(file);

            XPathNavigator nav = xmlDoc.CreateNavigator();

            // Compliant: Using a parameterized XPath query to prevent XPath injection.
            XPathExpression expr = nav.Compile("//knowledge[tags[contains(text(), $keyword)] and sensitivity/text() ='Public']");
            expr.SetParameter("keyword", input);

            var matchedNodes = nav.Select(expr);

            while (matchedNodes.MoveNext())
            {
                searchResult.Add(new Knowledge { Title = matchedNodes.Current.Value });
            }

            return searchResult;
        }
    }

    public class Knowledge
    {
        public string Title { get; set; }
        // Add other properties as needed
    }
}
//{/fact}