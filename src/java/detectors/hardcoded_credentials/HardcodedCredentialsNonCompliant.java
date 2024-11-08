// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-do-not-hardcode-database-password@v1.0 defects=1}
import java.sql.Connection;
import java.sql.DriverManager;

public class HardcodedCredentialsNonCompliant {

    // Noncompliant: Database password is hardcoded in the connection string, posing a security risk.
    public void nonCompliant() throws Exception {
        final Connection connection = DriverManager.getConnection("some url",
                "username", "password");
        connection.close();
    }
}
// {/fact}