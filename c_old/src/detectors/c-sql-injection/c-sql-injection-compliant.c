// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-sql-injection@v1.0 defects=0}
#include <stdio.h>
#include <mysql.h>
#include <stdlib.h>

void compliant(int argc, char** argv) {
    MYSQL *connection = mysql_init(NULL);

    if (mysql_real_connect(connection, "localhost", "root", "root_passwd", NULL, 0, NULL, 0) == NULL) {
        fprintf(stderr, "%s\n", mysql_error(connection));
        mysql_close(connection);
        exit(1);
    }

    // Compliant: Using prepared statements to prevent SQL injection
    MYSQL_STMT *stmt = mysql_stmt_init(connection);
    if (!stmt) {
        fprintf(stderr, "mysql_stmt_init() failed\n");
        mysql_close(connection);
        exit(1);
    }

    const char *query = "SELECT * FROM users WHERE name = ?";
    if (mysql_stmt_prepare(stmt, query, strlen(query))) {
        fprintf(stderr, "mysql_stmt_prepare() failed\n");
        mysql_stmt_close(stmt);
        mysql_close(connection);
        exit(1);
    }

    MYSQL_BIND bind[1];
    memset(bind, 0, sizeof(bind));
    bind[0].buffer_type = MYSQL_TYPE_STRING;
    bind[0].buffer = argv[1];
    bind[0].buffer_length = strlen(argv[1]);

    if (mysql_stmt_bind_param(stmt, bind)) {
        fprintf(stderr, "mysql_stmt_bind_param() failed\n");
        mysql_stmt_close(stmt);
        mysql_close(connection);
        exit(1);
    }
}

int main(int argc, char** argv) {
    if (argc < 2) {
        printf("Usage: %s <name>\n", argv[0]);
        return 1;
    }
    compliant(argc, argv);
    return 0;
}

// {/fact}
