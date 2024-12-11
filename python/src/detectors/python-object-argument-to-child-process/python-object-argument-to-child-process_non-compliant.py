#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-object-argument-to-child-process@v1.0 defects=1}
from multiprocessing import Pipe
from multiprocessing import Process
import traceback
import myapplication

def check_database_connection():
    client = myapplication.get_client()
    pipe = Pipe()
    try:
        client.db.collection.find_one()
    except:
        traceback.print_exc()
        pipe.send(True)

def noncompliant_case():
    cp, cc = Pipe()
    p = Process(target=check_database_connection)
    # Noncompliant: Creating Pipe object inside child process function.
    p.start()
# {/fact}
