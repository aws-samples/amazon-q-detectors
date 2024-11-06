// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-sql-injection@v1.0 defects=0}
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    int dummy;
} MYSQL;

MYSQL *mysql_init(MYSQL *mysql) {
    return (MYSQL*)malloc(sizeof(MYSQL));
}

MYSQL *mysql_real_connect(MYSQL *mysql, const char *host, const char *user,
                          const char *passwd, const char *db, unsigned int port,
                          const char *unix_socket, unsigned long clientflag) {
    return mysql;
}

void mysql_close(MYSQL *mysql) {
    free(mysql);
}

int mysql_query(MYSQL *mysql, const char *query) {
    printf("Executing query: %s\n", query);
    return 0;
}

const char *mysql_error(MYSQL *mysql) {
    return "Mock error message";
}

void compliant() {
    //Compliant : Use parameterized queries, implement input validation, and sanitize data using `mysql_real_escape_string()` instead of injecting SQL commands.
   MYSQL *connection = mysql_init(NULL);

   if (mysql_real_connect(connection, "localhost", "root", "root_passwd", NULL, 0, NULL, 0) == NULL) {
       fprintf(stderr, "%s\n", mysql_error(connection));
       mysql_close(connection);
       exit(1);
   }
   char query[200];
   sprintf(query, "SELECT * FROM users WHERE name = 'John'");

   mysql_query(connection, query);
   mysql_close(connection);
}

int main() {
   compliant();
   return 0;
}
// {/fact}