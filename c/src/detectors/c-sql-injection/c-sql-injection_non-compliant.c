// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-sql-injection@v1.0 defects=1}

#include <stdio.h>
#include <mysql.h>
#include <stdlib.h>

void nonCompliant(int argc, char** argv) {
    MYSQL *connection = mysql_init(NULL);

    if (mysql_real_connect(connection, "localhost", "root", "root_passwd", NULL, 0, NULL, 0) == NULL) {
        fprintf(stderr, "%s\n", mysql_error(connection));
        mysql_close(connection);
        exit(1);
    }

    char query[200];

    // Noncompliant: Directly inserting user input into SQL query, vulnerable to SQL injection.
    sprintf(query, "SELECT * FROM users WHERE name = '%s'", argv[1]);

    mysql_query(connection, query);

    mysql_close(connection);
}

int main(int argc, char** argv) {
    if (argc < 2) {
        printf("Usage: %s <name>\n", argv[0]);
        return 1;
    }
    nonCompliant(argc, argv);
    return 0;
}

// {/fact}
