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

    // Noncompliant: Unsanitized user input in SQL query can lead to SQL injection.
    sprintf(query, "SELECT * FROM users WHERE name = '%s'", argv[1]); 
    mysql_query(connection, query);
    mysql_close(connection);
}

// {/fact}
