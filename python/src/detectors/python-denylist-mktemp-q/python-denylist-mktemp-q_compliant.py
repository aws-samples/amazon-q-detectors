# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-denylist-mktemp-q@v1.0 defects=0}
import hotshot, hotshot.stats
import tempfile
from django.conf import settings

def compliant(request):
    if (settings.DEBUG or request.user.is_superuser) and 'prof' in request.GET:
        # Compliant: Using the `tempfile.NamedTemporaryFile()` API and passing the `delete=False` parameter to create temporary files.
        with tempfile.NamedTemporaryFile(delete=False) as temp_file:
            tmpfile = temp_file.name
        prof = hotshot.Profile(tmpfile)
# {/fact}
