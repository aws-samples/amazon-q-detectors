#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-use-hardcoded-email-credentials@v1.0 defects=0}
import smtplib
from email.mime.text import MIMEText
from email.header import Header
from_email = 'from_email@xxx.com'
import os

def compliant():
    # Compliant: Use environment variables to manage credentials securely.
    gmail_user = os.environ['GMAIL_FROM']
    gmail_password = os.environ['GMAIL_PASSWORD']
    to = os.environ['SEND_TO'].split(sep=';')
    server = smtplib.SMTP_SSL('smtp.gmail.com', 465)
    server.login(gmail_user, gmail_password)
    server.sendmail(gmail_user, to, 'message')
    server.quit()
# {/fact}
