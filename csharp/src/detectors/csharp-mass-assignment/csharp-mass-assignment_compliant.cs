// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-mass-assignment@v1.0 defects=0}
using Microsoft.AspNetCore.Mvc;

public class UserController : Controller
{
    private readonly ApplicationDbContext context;

    public UserController(ApplicationDbContext context)
    {
        this.context = context;
    }

    // Compliant: Using `[Bind]` attribute to explicitly whitelist allowed properties, preventing mass assignment.
    public IActionResult CompliantCreate([Bind(nameof(UserModel.Name))] UserModel model)
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