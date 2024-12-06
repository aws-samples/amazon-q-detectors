# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-zip-slip@v1.0 defects=0}
import zipfile

def compliant(archive_name):
    zf = zipfile.ZipFile(archive_name)
    # Compliant: Expanding an archive file with validation.
    safe_members = [m for m in zf.namelist() if not m.startswith('/') and '..' not in m]
    zf.extractall(path=".", members=safe_members)
    zf.close()
# {/fact}
