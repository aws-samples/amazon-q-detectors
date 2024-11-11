#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-sql-injection@v1.0 defects=1}
from django.http import HttpRequest, JsonResponse
import sqlite3

def execute_query_noncompliant(request : HttpRequest):
    name = request.GET.get("name")
    query = "SELECT * FROM Users WHERE name = " + name + ";"
    with sqlite3.connect("example.db") as connection:
        cursor = connection.cursor()
        # Noncompliant: User input is used without sanitization.
        cursor.execute(query)
        connection.commit()
        connection.close()
# {/fact}
