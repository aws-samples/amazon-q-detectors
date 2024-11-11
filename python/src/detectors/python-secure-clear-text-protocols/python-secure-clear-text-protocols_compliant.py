#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-secure-clear-text-protocols@v1.0 defects=0}
import ftplib

def ftp_connection_compliant():
    # Compliant: Secure `FTP_TLS` is used.
    cnx = ftplib.FTP_TLS("ftp.example.com")
# {/fact}
