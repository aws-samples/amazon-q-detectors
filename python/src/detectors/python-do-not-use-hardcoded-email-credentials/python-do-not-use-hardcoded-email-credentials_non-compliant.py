#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-use-hardcoded-email-credentials@v1.0 defects=1}
import smtplib
from email.mime.text import MIMEText
from email.header import Header
import os

def non_compliant():
    # Noncompliant: Storing hardcoded email credentials can create significant security vulnerabilities.
    password = "XXXXXXXXX"
    username = "XXXXXXX@address.com"
    smtphost = "mail.authsmtp.com:2525"
    server = smtplib.SMTP(smtphost)
    server.starttls()
    server.login(username, password)
    server.quit()
# {/fact}
