// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-incorrect-use-of-free-memory@v1.0 defects=0}
#include <stdio.h>
#include <stdlib.h>

int compliant(void)
{
    listint_t *head;

    head = NULL;
    add_nodeint_end(&head, 1);
    add_nodeint_end(&head, 17);
    add_nodeint_end(&head, 972);
    add_nodeint_end(&head, 50);

    // Compliant: Memory is accessed appropriately before being freed.
    print_listint(head);

    return (0);
}
// {/fact}

