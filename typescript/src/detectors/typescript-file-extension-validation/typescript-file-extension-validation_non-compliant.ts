// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-file-extension-validation@v1.0 defects=1}
import express from "express";
import fileUpload from "express-fileupload";

const app = express();
app.use(fileUpload());

app.post("/", (req: express.Request, res: express.Response) => {
    const file = (req.files?.file as fileUpload.UploadedFile);
    const filename = file.name;
    // Noncompliant: Accepts and saves all uploaded files without any validation, potentially allowing malicious file uploads.
    file.mv("./uploads/" + filename);
});
// {/fact}
