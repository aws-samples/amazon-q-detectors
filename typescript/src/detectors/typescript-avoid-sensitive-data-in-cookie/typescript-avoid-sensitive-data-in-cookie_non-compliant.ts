// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-avoid-sensitive-data-in-cookie@v1.0 defects=1}
import express, { Request, Response } from 'express';
import cookieParser from "cookie-parser";

const app = express();
app.use(cookieParser());

app.get("/noncompliant", (req: Request, res: Response) => {
    let password = req.body("password");
    // Noncompliant: Sensitive data is stored in cookies.
    res.cookie("password", password);
});

app.listen(3000, () => {
    console.log("Server is running on port 3000");
});
// {/fact}
