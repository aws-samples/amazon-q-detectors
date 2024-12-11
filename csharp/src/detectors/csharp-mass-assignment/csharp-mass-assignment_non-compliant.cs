// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-mass-assignment@v1.0 defects=1}
using Microsoft.AspNetCore.Mvc;

public class UserController : Controller
{
    private readonly ApplicationDbContext context;

    public UserController(ApplicationDbContext context)
    {
        this.context = context;
    }

    // Noncompliant: Not using `[Bind]` attribute or any other method to restrict property assignment, vulnerable to mass assignment.
    public IActionResult NonCompliantCreate(UserModel model)
    {
        context.SaveChanges();
        return View("Index", model);
    }
}

public class UserModel
{
    public string Name { get; set; }
}
// {/fact}