#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-sql-injection@v1.0 defects=0}
from django.http import HttpRequest, JsonResponse
import sqlite3

def execute_query_compliant(request: HttpRequest):
    name = request.GET.get("name")
    query = "SELECT * FROM Users WHERE name = ?;"
    with sqlite3.connect("example.db") as connection:
        cursor = connection.cursor()
        # Compliant: A parameterized query is used to pass an external input.
        cursor.execute(query, (name,))
        connection.commit()
# {/fact}
