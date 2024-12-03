# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-denylist-mktemp-q@v1.0 defects=1}
import hotshot, hotshot.stats
import tempfile
from django.conf import settings

def non_compliant(request):
    if (settings.DEBUG or request.user.is_superuser) and 'prof' in request.GET:
        # Noncompliant: Use of `mktemp` which is insecure and deprecated function.
        tmpfile = tempfile.mktemp()
        prof = hotshot.Profile(tmpfile)
# {/fact}
