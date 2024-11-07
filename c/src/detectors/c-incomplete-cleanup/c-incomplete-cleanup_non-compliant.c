// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-incomplete-cleanup@v1.0 defects=1}
#include <stdio.h>
#include <stdlib.h>

int noncompliant(int print) {

      // Noncompliant: File descriptors are not appropriately released or closed.
      FILE *f = fopen("example.txt", "w+");
      if (!f) {
          perror("fopen() failed");
          return 1;
      }

      if (print) {
          char buffer[256];
          while (fgets(buffer, 256, f)) {
              printf("%s", buffer);
          }
      }

      return 0;
}
// {/fact}
