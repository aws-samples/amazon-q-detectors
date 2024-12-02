// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-do-not-expose-puppeteer@v1.0 defects=0}
const  puppeteer  = require('puppeteer');
const express = require('express');
const app = express();

    // Compliant: Disabled remote debugging in production environments.
    app.post("/", async () => {

      const brow = await puppeteer.launch({args:['--somethin-else', '--more-examples']});
      const pg = await browser.newPage();
      await pg.goto('https://example123.com');
      await brow.close();
    })
// {/fact}
