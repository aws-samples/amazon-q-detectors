#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0
	 
# {fact rule=python-unsanitized-input-sendmail@v1.0 defects=1}
from django.core.mail import send_mail

subject = 'Test subject'
message = 'Test message'
from_email = 'test@pqr.com'
to_email = 'test@abc.com'

def django_non_compliant(request):
    html_msg = request.POST.get('html_msg')
    # Noncompliant: User input is not sanitized before sending mail.
    send_mail(subject, message, from_email, to_email,
              html_message=html_msg)
# {/fact}
