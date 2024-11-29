#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-unsanitized-input-sendmail@v1.0 defects=0}
from django.core.mail import send_mail
import html

subject = 'Test subject'
message = 'Test message'
from_email = 'test@pqr.com'
to_email = 'test@abc.com'

def django_compliant(request):
    html_msg = request.POST.get('html_msg')
    # Compliant: User input is sanitized before sending mail.
    send_mail(subject, message, from_email, to_email,
              html_message=html.escape(html_msg))
# {/fact}
