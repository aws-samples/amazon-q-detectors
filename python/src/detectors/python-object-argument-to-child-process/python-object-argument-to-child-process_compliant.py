#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-object-argument-to-child-process@v1.0 defects=0}
from multiprocessing import Pipe
from multiprocessing import Process
import traceback
import myapplication

def check_database_connection(pipe):
    client = myapplication.get_client()
    try:
        client.db.collection.find_one()
    except:
        traceback.print_exc()
        pipe.send(True)

def compliant_case():
    cp, cc = Pipe()
    p = Process(target=check_database_connection, args=(cc,))
    # Compliant: Pipe object is passed as an argument to the child process.
    p.start()
# {/fact}
