// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-do-not-hardcode-database-password@v1.0 defects=0}
import java.sql.Connection;
import java.sql.DriverManager;

public class HardcodedCredentialsCompliant {

    // Compliant: Database password is obtained from system property, avoiding hardcoding and improving security.
    public void compliant() throws Exception {
        final Connection connection = DriverManager.getConnection("some url",
                "user", System.getProperty("pwd"));
        connection.close();
    }
}
// {/fact}