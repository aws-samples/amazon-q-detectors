// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-sql-injection@v1.0 defects=0}
#include <iostream>
#include <sqlite3.h>

int compliant(const std::string& username, const std::string& password) {
    sqlite3* db;
    sqlite3_open("users.db", &db);

    std::string query = "SELECT * FROM users WHERE username = ? AND password = ?;";

    sqlite3_stmt* stmt;
    if (sqlite3_prepare_v2(db, query.c_str(), -1, &stmt, nullptr) == SQLITE_OK) {
        // Compliant: Used parameterized queries or prepared statements to avoid sql injection.
        sqlite3_bind_text(stmt, 1, username.c_str(), -1, SQLITE_STATIC);
        sqlite3_bind_text(stmt, 2, password.c_str(), -1, SQLITE_STATIC);
        if (sqlite3_step(stmt) == SQLITE_ROW) {
            std::cout << "Authentication successful.\n";
            return 1;
        }
    }

    std::cout << "Authentication failed.\n";
    return 0;
}
// {/fact}
