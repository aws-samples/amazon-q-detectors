// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-sql-injection@v1.0 defects=1}
#include <iostream>
#include <sqlite3.h>

int noncompliant(const std::string& username, const std::string& password) {
    sqlite3* db;
    sqlite3_open("users.db", &db);

    std::string query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "';";

    sqlite3_stmt* stmt;
    if (sqlite3_prepare_v2(db, query.c_str(), -1, &stmt, nullptr) == SQLITE_OK) {
        // Noncompliant: Construction of query for external input.
        if (sqlite3_step(stmt) == SQLITE_ROW) {
            std::cout << "Authentication successful.\n";
            return 1;
        }
    }

    std::cout << "Authentication failed.\n";
    return 0;
}
// {/fact}
