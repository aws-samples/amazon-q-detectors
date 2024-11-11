#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-secure-clear-text-protocols@v1.0 defects=1}
import ftplib

def ftp_connection_noncompliant():
    # Noncompliant: Insecure `FTP` is used.
    cnx = ftplib.FTP("ftp://anonymous@example.com")
# {/fact}
