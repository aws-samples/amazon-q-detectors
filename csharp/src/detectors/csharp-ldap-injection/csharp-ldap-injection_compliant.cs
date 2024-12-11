// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-ldap-injection@v1.0 defects=0}
using System.DirectoryServices;

public class LdapInjectionExample
{
    private const string SAMAccountNameAttribute = "sAMAccountName";
    private const string DisplayNameAttribute = "displayName";

    public User CompliantLogin(string userName, string password, LdapConfig config)
    {
        using (DirectoryEntry entry = new DirectoryEntry(config.Path, config.UserDomainName + "\\" + userName, password))
        {
            using (DirectorySearcher searcher = new DirectorySearcher(entry))
            {
                // Compliant: Using `LdapFilterEncode` to prevent LDAP injection.
                searcher.Filter = String.Format("({0}={1})", Encoder.LdapFilterEncode(SAMAccountNameAttribute), Encoder.LdapFilterEncode(userName));
                searcher.PropertiesToLoad.Add(DisplayNameAttribute);
                searcher.PropertiesToLoad.Add(SAMAccountNameAttribute);
                var result = searcher.FindOne();
                if (result != null)
                {
                    var displayName = result.Properties[DisplayNameAttribute];
                    var samAccountName = result.Properties[SAMAccountNameAttribute];

                    return new User
                    {
                        DisplayName = displayName == null || displayName.Count <= 0 ? null : displayName[0].ToString(),
                        UserName = samAccountName == null || samAccountName.Count <= 0 ? null : samAccountName[0].ToString()
                    };
                }
            }
        }

        return null;
    }
}

public class User
{
    public string DisplayName { get; set; }
    public string UserName { get; set; }
}

public class LdapConfig
{
    public string Path { get; set; }
    public string UserDomainName { get; set; }
}

public static class Encoder
{
    public static string LdapFilterEncode(string input)
    {
        return input;
    }
}
//{/fact}